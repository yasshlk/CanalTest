package com.yshlk.meetingplanner.entities;
/* Created By yassine */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "RESERVATION_EQUIPEMENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReservationEquipement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime heure_de_reservation;
    @OneToOne
    @JoinColumn(name = "equipsup_id")
    private EquipementSupp equipementSupp;
    private LocalTime reserv_debut_time;
    private LocalTime reserv_fin_time;
}
