package com.yshlk.meetingplanner.entities;
/* Created By yassine */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "EQUIPEMENT_SUPP")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class EquipementSupp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private boolean isUsed;
    private LocalTime start_use;
    private LocalTime end_use;

}
