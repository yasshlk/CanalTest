package com.yshlk.meetingplanner.services;
/* Created By yassine */


import com.yshlk.meetingplanner.entities.Reunion;
import com.yshlk.meetingplanner.repositories.ReunionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionServiceImpl implements ReunionService {

    private static final Logger logger = LogManager.getLogger(ReunionServiceImpl.class);

    @Autowired
    ReunionRepository reunionRepository;

    @Override
    public List<Reunion> getAllReunions() {
        logger.debug("Calling Get All Meeting Service");
        return reunionRepository.findAll();
    }
}
