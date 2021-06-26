package com.yshlk.meetingplanner.services;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.ReservationEquipement;
import com.yshlk.meetingplanner.repositories.ReservationEquipementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationEquipementServiceImpl implements  ReservationEquipementService{

    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    ReservationEquipementRepository reservationEquipementRepository;


    /**
     *
     * @return
     */
    @Override
    public List<ReservationEquipement> getAllEquipmentReservation() {
        logger.debug("Call Reservation Equipement Find All Service");
        return reservationEquipementRepository.findAll();
    }
}
