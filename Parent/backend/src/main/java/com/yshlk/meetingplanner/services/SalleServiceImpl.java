package com.yshlk.meetingplanner.services;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.Salle;
import com.yshlk.meetingplanner.repositories.SalleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService{

    private static final Logger logger = LogManager.getLogger(SalleServiceImpl.class);

    @Autowired
    SalleRepository salleRepository;

    /**
     *
     * @return
     */
    @Override
    public List<Salle> getAllRoom() {
        logger.debug("Calling Get All Room Service");
        return salleRepository.findAll();
    }


}
