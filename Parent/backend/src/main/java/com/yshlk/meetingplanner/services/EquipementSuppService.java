package com.yshlk.meetingplanner.services;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.EquipementSupp;

import java.util.List;

public interface EquipementSuppService {

    /**
     *
     * @return
     */
    List<EquipementSupp> getAllEquipement();

    /**
     *
     * @param type
     * @return
     */
    List<EquipementSupp> getEquipementSuppByType( String type);
}
