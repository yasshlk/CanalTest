package com.yshlk.meetingplanner.services;
/* Created By yassine */


import com.yshlk.meetingplanner.entities.EquipementSupp;
import com.yshlk.meetingplanner.repositories.EquipementSuppRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementSuppServiceImpl implements EquipementSuppService {

    private static final Logger logger = LogManager.getLogger(EquipementSuppServiceImpl.class);

    @Autowired
    EquipementSuppRepository equipementSuppRepository;

    /**
     *
     * @return
     */
    @Override
    public List<EquipementSupp> getAllEquipement() {
        logger.debug(""," Calling Find All Service Equipement");
        return equipementSuppRepository.findAll();
    }

    /**
     *
     * @param type
     * @return
     */
    @Override
    public List<EquipementSupp> getEquipementSuppByType(String type) {
        logger.debug(" Calling Find Equipement By Type");
        return equipementSuppRepository.findEquipementSuppByType(type);
    }
}
