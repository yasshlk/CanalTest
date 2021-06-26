package com.yshlk.meetingplanner.entities;
/* Created By yassine */

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime heure_de_reservation;
    @OneToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @OneToOne
    @JoinColumn(name = "reunion_id")
    private Reunion reunion;
    private LocalTime reserv_debut_time;
    private LocalTime reserv_fin_time;


}
