package com.yshlk.meetingplanner.entities;
/* Created By yassine */

import com.yshlk.meetingplanner.utils.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SALLE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int capacity;
    @Convert(converter = StringListConverter.class)
    private List<String> equipments;



}
