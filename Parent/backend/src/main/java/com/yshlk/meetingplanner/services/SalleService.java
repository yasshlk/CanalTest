package com.yshlk.meetingplanner.services;
/* Created By yassine */
import com.yshlk.meetingplanner.entities.Salle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SalleService {

    /**
     *
     * @return
     */
    List<Salle> getAllRoom();
}
