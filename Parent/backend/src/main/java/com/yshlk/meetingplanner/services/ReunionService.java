package com.yshlk.meetingplanner.services;
/* Created By yassine */

import com.yshlk.meetingplanner.entities.Reunion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ReunionService {

    List<Reunion> getAllReunions();
}
