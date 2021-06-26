package com.yshlk.meetingplanner.repositories;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalleRepository extends JpaRepository<Salle,Long>{

}
