package com.yshlk.meetingplanner.services;

import com.yshlk.meetingplanner.entities.ReservationEquipement;
import com.yshlk.meetingplanner.repositories.ReservationEquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReservationEquipementService {


    List<ReservationEquipement> getAllEquipmentReservation();
}
