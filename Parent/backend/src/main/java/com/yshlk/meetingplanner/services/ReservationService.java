package com.yshlk.meetingplanner.services;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Reservation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReservationService {

    /**
     *
     * @return
     */
    List<Reservation> effectuerReservation();

    /**
     *
     * @param id
     * @return
     */
    List<Reservation> getAllReservationBySalle(Long id);


    /**
     *
     * @return
     */
    List<Reservation> getAllReservations();
}
