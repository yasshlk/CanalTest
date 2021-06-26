package com.yshlk.meetingplanner.entities;
/* Created By yassine */

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "REUNION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private LocalTime start_time;
    private LocalTime end_time;
    private int participant;

}
