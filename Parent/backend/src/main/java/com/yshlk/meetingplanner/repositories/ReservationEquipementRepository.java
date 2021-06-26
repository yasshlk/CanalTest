package com.yshlk.meetingplanner.repositories;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Reservation;
import com.yshlk.meetingplanner.entities.ReservationEquipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationEquipementRepository extends JpaRepository<ReservationEquipement, Long> {

    /**
     *
     * @param type
     * @return
     */
    @Query("SELECT r FROM ReservationEquipement r WHERE r.equipementSupp.type = ?1 ")
    List<ReservationEquipement> existsReservationByEquipementSupp(String type );
}
