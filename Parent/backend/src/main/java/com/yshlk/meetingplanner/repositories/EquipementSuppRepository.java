package com.yshlk.meetingplanner.repositories;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.EquipementSupp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipementSuppRepository extends JpaRepository<EquipementSupp, Long> {

    /**
     *
     * @param type
     * @return
     */
    List<EquipementSupp> findEquipementSuppByType(String type);
}
