package com.yshlk.meetingplanner.services;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.*;
import com.yshlk.meetingplanner.repositories.ReservationEquipementRepository;
import com.yshlk.meetingplanner.repositories.ReservationRepository;
import com.yshlk.meetingplanner.repositories.ReunionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    SalleService salleService;
    @Autowired
    EquipementSuppService equipementSuppService;
    @Autowired
    ReunionRepository reunionRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationEquipementRepository reservationEquipementRepository;

    // List Of needed Equipment depending on Meeting type
    private List<String> equipementReunion = new ArrayList<>();

    @Override
    public List<Reservation> effectuerReservation() {

        logger.info("Calling Effectuer Reservation");

        if(reservationRepository.findAll().size() == reunionRepository.findAll().size()){
            logger.debug("Reservation already Done");
            return reservationRepository.findAll();
        }

        List<Reunion> listReunion = reunionRepository.findAll();
        List<Salle> sallesDispo = salleService.getAllRoom();

        List<EquipementSupp> equipementsSuppDispo = new ArrayList<>();

        for ( Reunion reunion: listReunion) {
             // filtrer les salles valides pour type de reunion
            logger.debug("Finding Appropriate Room for the type of meeting");
            List<Salle> sallesValides = sallesDispo.stream().filter(salle ->{
                return isValidSalleTypeReunion(reunion,salle);
                }).filter(salle -> salle.getCapacity() >= reunion.getParticipant()).collect(Collectors.toList());

            // filtrer les salles valides et non reserver
            if(sallesValides.size() > 0){
                logger.debug("Checking which appropriate room is free");
                sallesValides = sallesValides.stream().filter(salle -> { return nonReservee(salle,reunion.getStart_time());}).collect(Collectors.toList());
                if(sallesValides.size() > 0 ){
                    logger.debug("Create Reservation for meeting combine with room");
                    reservationRepository.
                            save(new Reservation(null, LocalDateTime.now(),sallesValides.get(0),reunion,reunion.getStart_time(),reunion.getEnd_time()));
                }
            }

            // Adapter salle pour reunion avec equipement Supplementaire
            if(sallesValides.size() == 0){
                logger.debug("Checking which appropriate room is free to Add Equipment");
                sallesValides = sallesDispo.stream().
                        filter(salle -> {return nonReservee(salle,reunion.getStart_time());} ).
                        collect(Collectors.toList());
                logger.debug("Finding needed and unused Equipments ");
                Salle tempoSalle =  equipementManquantSalle(sallesValides,reunion.getType());
                List<EquipementSupp> equipementSuppsDisponnible = findEquipementLibre(reunion);

                reserverEquipementManquant(this.equipementReunion,tempoSalle,equipementSuppsDisponnible,reunion);
                reservationRepository.save(new Reservation(null, LocalDateTime.now(),tempoSalle,reunion,reunion.getStart_time(),reunion.getEnd_time()));

            }

        }
        logger.debug("Returning all reservations created");
       return reservationRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Reservation> getAllReservationBySalle(Long id) {
        return reservationRepository.getReservationBySalle(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     *
     * @param salle
     * @param debutReunion
     * @return
     */
    public boolean nonReservee(Salle  salle, LocalTime debutReunion){
        // Filter of already reserved room
        List<Reservation> reservationsBySalleList = reservationRepository.getReservationBySalle(salle.getId());
        if(reservationsBySalleList.size() == 0)
            return true;
        List<Reservation> res =  reservationsBySalleList.stream().filter(reservation -> isFreeAndCleaned(reservation,debutReunion))
                    .collect(Collectors.toList());
        if(res.size() > 0) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param reservation
     * @param debutreunion
     * @return
     */
    public boolean isFreeAndCleaned(Reservation reservation,LocalTime debutreunion){
        // Filter of unused and cleaned room ready to be use
        if((!reservation.getReserv_debut_time().equals(debutreunion) &&
                reservation.getReserv_fin_time().plusHours(1).equals(debutreunion)) || reservation.getReserv_debut_time().isAfter(debutreunion)) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param reunion
     * @param salle
     * @return
     */
    public boolean isValidSalleTypeReunion(Reunion reunion, Salle salle){
        // Filter appropriate room with needed equipment

        this.equipementReunion.clear();
        if(reunion.getType().equals(TypeReunionEnum.VC.label)){

            this.equipementReunion.add(EquipmentEnum.ECRAN.label);
            this.equipementReunion.add(EquipmentEnum.WEBCAM.label);
            this.equipementReunion.add(EquipmentEnum.PIEUVRE.label);

            return salle.getEquipments().containsAll(this.equipementReunion);
        }
        if(reunion.getType().equals(TypeReunionEnum.RC.label)){
            this.equipementReunion.add(EquipmentEnum.TABLEAU.label);
            this.equipementReunion.add(EquipmentEnum.ECRAN.label);
            this.equipementReunion.add(EquipmentEnum.PIEUVRE.label);

            return salle.getEquipments().containsAll(this.equipementReunion);
        }
        if(reunion.getType().equals(TypeReunionEnum.SPEC.label)){
            return salle.getEquipments().contains(EquipmentEnum.TABLEAU.label);
        }
        if(reunion.getType().equals(TypeReunionEnum.RS.label)){
            return salle.getCapacity() > 3;
        }

        return false;
    }


    /**
     *
     * @param salles
     * @param type
     * @return
     */
    public Salle equipementManquantSalle(List<Salle> salles, String type){

        // Finding Missing Equipment for the meeting And most accurate Room to use

        Salle salleUsage = null;
        List<String> equipements = new ArrayList<>();
        this.equipementReunion.clear();
        if(type.equals(TypeReunionEnum.VC.label)){
            this.equipementReunion.add(EquipmentEnum.ECRAN.label);
            this.equipementReunion.add(EquipmentEnum.WEBCAM.label);
            this.equipementReunion.add(EquipmentEnum.PIEUVRE.label);
        }
        if(type.equals(TypeReunionEnum.RC.label)){
            this.equipementReunion.add(EquipmentEnum.TABLEAU.label);
            this.equipementReunion.add(EquipmentEnum.ECRAN.label);
            this.equipementReunion.add(EquipmentEnum.PIEUVRE.label);
        }
        if(type.equals(TypeReunionEnum.SPEC.label)){
            this.equipementReunion.add(EquipmentEnum.TABLEAU.label);
        }
        for (Salle salle:salles) {
            if(salle.getEquipments().stream().anyMatch(equipementReunion::contains)){
                salleUsage = salle;
                break;
            }
        }
        if(salleUsage == null){
            for (Salle salle: salles) {
                if(salle.getEquipments().contains(type))
                    salleUsage = salle;
                    break;
            }

            if(salleUsage == null) {
                salleUsage = salles.get(0);
            }
        }
        return salleUsage;
    }


    /**
     * Filter unused equipments ready to be used
     * @param reunion
     * @return
     */
    public List<EquipementSupp> findEquipementLibre(Reunion reunion){

        List<ReservationEquipement> res = reservationEquipementRepository.findAll();
        List<EquipementSupp> equipementSuppListDispo = equipementSuppService.getAllEquipement();
        if(res.size() >0){
           List<ReservationEquipement> reservationEquipements =
                   res.stream().filter(reservationEquipement -> { return isLibreEquipement(reservationEquipement,reunion.getStart_time());}).
                           collect(Collectors.toList());

           if(reservationEquipements.size() == 0 ) {
               return equipementSuppListDispo;
           }

            if(reservationEquipements.size() > 0 ) {
                for (ReservationEquipement resEqui: reservationEquipements)
                {
                    equipementSuppListDispo.remove(resEqui.getEquipementSupp());
                }
                return equipementSuppListDispo;
            }
        }
        return  equipementSuppListDispo;
    }

    /**
     *
     * @param reservationEquipement
     * @param debutReunion
     * @return
     */
    public boolean isLibreEquipement(ReservationEquipement reservationEquipement,LocalTime debutReunion){
        if(!reservationEquipement.getReserv_debut_time().equals(debutReunion)) {
            return true;
        }
        return false;
    }


    /**
     * Make reservation of the missing equipment for the meeting
     * @param equipementsManquants
     * @param salle
     * @param equipementSuppsDispo
     * @param reunion
     */
    public void reserverEquipementManquant(List<String> equipementsManquants , Salle salle, List<EquipementSupp> equipementSuppsDispo,Reunion reunion){
        EquipementSupp equipementTemp = new EquipementSupp();
             for (String equipement: equipementsManquants) {
                if(!salle.getEquipments().contains(equipement)){
                    equipementTemp = equipementSuppsDispo.stream().filter(equipementSupp -> equipementSupp.getType().equals(equipement)).findFirst().get();
                    reservationEquipementRepository.save(new ReservationEquipement(null,LocalDateTime.now(),equipementTemp,reunion.getStart_time(),reunion.getEnd_time()));
                }
            }


    }
}
