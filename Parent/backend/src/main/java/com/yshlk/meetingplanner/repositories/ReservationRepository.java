package com.yshlk.meetingplanner.repositories;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    /**
     *
     * @param idSalle
     * @return
     */

    @Query("SELECT r FROM Reservation r WHERE r.salle.id = ?1")
    List<Reservation> getReservationBySalle(Long idSalle );

}
