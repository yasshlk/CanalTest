package com.yshlk.meetingplanner.repositories;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long> {
}
