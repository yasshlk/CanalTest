package com.yshlk.meetingplanner.controllers;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.Reservation;
import com.yshlk.meetingplanner.entities.ReservationEquipement;
import com.yshlk.meetingplanner.entities.Reunion;
import com.yshlk.meetingplanner.entities.Salle;
import com.yshlk.meetingplanner.services.ReservationEquipementService;
import com.yshlk.meetingplanner.services.ReservationService;
import com.yshlk.meetingplanner.services.ReunionService;
import com.yshlk.meetingplanner.services.SalleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/meeting")
public class ReservationController {


    private static final Logger logger = LogManager.getLogger(ReservationController.class);

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationEquipementService reservationEquipementService;

    @Autowired
    ReunionService reunionService;

    @Autowired
    SalleService salleService;


    /**
     *
     * @return
     */
    @GetMapping("/reserver")
    ResponseEntity<List<Reservation>> reserver(){
        logger.debug(" Call Effectation des reservation WS ");
        return new ResponseEntity<>(reservationService.effectuerReservation(), HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/reunions")
    ResponseEntity<List<Reunion>> getAllReunions(){
        logger.debug(" Call Find all Meeting WS ");
        return new ResponseEntity<>(reunionService.getAllReunions(), HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/salles")
    ResponseEntity<List<Salle>> getAllSalles(){
        logger.debug(" Call Find All Room WS ");
        return new ResponseEntity<>(salleService.getAllRoom(), HttpStatus.OK);
    }

    @GetMapping("/reservations")
    ResponseEntity<List<Reservation>> getAllReservaions(){
        logger.debug(" Call Find All Room WS ");
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/getreservationbysalle/{id}")
    ResponseEntity<List<Reservation>> getSalleReservation(@PathVariable("id") Long id){
        logger.debug(" Call Find All reservation for Room Id : "+ id);
        return new ResponseEntity<>(reservationService.getAllReservationBySalle(id), HttpStatus.OK);
    }


    /**
     *
     * @return
     */
    @GetMapping("/reservationsequipement")
    ResponseEntity<List<ReservationEquipement>> getSalleReservation(){
        logger.debug(" Call Find All Equipment Reserrvation for Room Id ");
        return new ResponseEntity<>(reservationEquipementService.getAllEquipmentReservation(), HttpStatus.OK);
    }
}
