package com.yshlk.meetingplanner;

import com.yshlk.meetingplanner.entities.*;
import com.yshlk.meetingplanner.repositories.EquipementSuppRepository;
import com.yshlk.meetingplanner.repositories.ReunionRepository;
import com.yshlk.meetingplanner.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class MeetingPlannerApplication implements CommandLineRunner {

    @Autowired
    SalleRepository salleRepository;

    @Autowired
    ReunionRepository reunionRepository;

    @Autowired
    EquipementSuppRepository equipementSuppRepository;


    public static void main(String[] args) {
        SpringApplication.run(MeetingPlannerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        persistRooms();
        persistMeetings();
        persistEquipment();

    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }



    void persistEquipment(){

        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.ECRAN.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.ECRAN.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.ECRAN.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.ECRAN.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.ECRAN.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.PIEUVRE.label, false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.PIEUVRE.label, false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.PIEUVRE.label, false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.PIEUVRE.label, false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.WEBCAM.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.WEBCAM.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.WEBCAM.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.WEBCAM.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.TABLEAU.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
        equipementSuppRepository.save(new EquipementSupp(null, EquipmentEnum.TABLEAU.label,false, LocalTime.of(8,0), LocalTime.of(8,0)));
    }

    void persistMeetings(){

        reunionRepository.save(new Reunion(null,"Reunion 1", TypeReunionEnum.VC.label, LocalTime.of(9,0),LocalTime.of(10,0),8));
        reunionRepository.save(new Reunion(null,"Reunion 2", TypeReunionEnum.VC.label,LocalTime.of(9,0),LocalTime.of(10,0),6));
       reunionRepository.save(new Reunion(null,"Reunion 3",TypeReunionEnum.RC.label,LocalTime.of(11,0),LocalTime.of(12,0),4));
        reunionRepository.save(new Reunion(null,"Reunion 4",TypeReunionEnum.RS.label,LocalTime.of(11,0),LocalTime.of(12,0),2));
        reunionRepository.save(new Reunion(null,"Reunion 5",TypeReunionEnum.SPEC.label,LocalTime.of(11,0),LocalTime.of(12,0),9));
         reunionRepository.save(new Reunion(null,"Reunion 6",TypeReunionEnum.RC.label,LocalTime.of(9,0),LocalTime.of(10,0),7));
        reunionRepository.save(new Reunion(null,"Reunion 7",TypeReunionEnum.VC.label,LocalTime.of(8,0),LocalTime.of(9,0),9));
        reunionRepository.save(new Reunion(null,"Reunion 8",TypeReunionEnum.SPEC.label,LocalTime.of(8,0),LocalTime.of(9,0),10));
        reunionRepository.save(new Reunion(null,"Reunion 9",TypeReunionEnum.SPEC.label,LocalTime.of(9,0),LocalTime.of(10,0),5));
        reunionRepository.save(new Reunion(null,"Reunion 10",TypeReunionEnum.RS.label,LocalTime.of(9,0),LocalTime.of(10,0),4));
        reunionRepository.save(new Reunion(null,"Reunion 11",TypeReunionEnum.RC.label,LocalTime.of(9,0),LocalTime.of(10,0),8));
        reunionRepository.save(new Reunion(null,"Reunion 12",TypeReunionEnum.VC.label,LocalTime.of(11,0),LocalTime.of(12,0),12));
        reunionRepository.save(new Reunion(null,"Reunion 13",TypeReunionEnum.SPEC.label,LocalTime.of(11,0),LocalTime.of(12,0),5));
        reunionRepository.save(new Reunion(null,"Reunion 14",TypeReunionEnum.VC.label,LocalTime.of(8,0),LocalTime.of(9,0),3));
        reunionRepository.save(new Reunion(null,"Reunion 15",TypeReunionEnum.SPEC.label,LocalTime.of(8,0),LocalTime.of(9,0),2));
        reunionRepository.save(new Reunion(null,"Reunion 16",TypeReunionEnum.VC.label,LocalTime.of(8,0),LocalTime.of(9,0),12));
        reunionRepository.save(new Reunion(null,"Reunion 17",TypeReunionEnum.VC.label,LocalTime.of(10,0),LocalTime.of(11,0),6));
        reunionRepository.save(new Reunion(null,"Reunion 18",TypeReunionEnum.RS.label,LocalTime.of(11,0),LocalTime.of(12,0),2));
        reunionRepository.save(new Reunion(null,"Reunion 19",TypeReunionEnum.RS.label,LocalTime.of(9,0),LocalTime.of(10,0),4));
        reunionRepository.save(new Reunion(null,"Reunion 20",TypeReunionEnum.RC.label,LocalTime.of(9,0),LocalTime.of(10,0),7));

    }

    void persistRooms(){
        salleRepository.save(new Salle(null,"E1001",23, new ArrayList<String>(Arrays.asList(EquipmentEnum.NEANT.label))));
        salleRepository.save(new Salle(null,"E1002",10, new ArrayList<String>(Arrays.asList(EquipmentEnum.ECRAN.label))));
        salleRepository.save(new Salle(null,"E1003",8, new ArrayList<String>(Arrays.asList(EquipmentEnum.PIEUVRE.label))));
        salleRepository.save(new Salle(null,"E1004",4, new ArrayList<String>(Arrays.asList(EquipmentEnum.TABLEAU.label))));
        salleRepository.save(new Salle(null,"E2001",4, new ArrayList<String>(Arrays.asList(EquipmentEnum.NEANT.label))));
        salleRepository.save(new Salle(null,"E2002",15, new ArrayList<String>(Arrays.asList(EquipmentEnum.ECRAN.label, EquipmentEnum.WEBCAM.label))));
        salleRepository.save(new Salle(null,"E2003",7, new ArrayList<String>(Arrays.asList(EquipmentEnum.NEANT.label))));
        salleRepository.save(new Salle(null,"E2004",9, new ArrayList<String>(Arrays.asList(EquipmentEnum.TABLEAU.label))));
        salleRepository.save(new Salle(null,"E3001",13, new ArrayList<String>(Arrays.asList(EquipmentEnum.ECRAN.label, EquipmentEnum.WEBCAM.label, EquipmentEnum.PIEUVRE.label))));
        salleRepository.save(new Salle(null,"E3002",8, new ArrayList<String>(Arrays.asList(EquipmentEnum.NEANT.label))));
        salleRepository.save(new Salle(null,"E3003",9, new ArrayList<String>(Arrays.asList(EquipmentEnum.ECRAN.label, EquipmentEnum.PIEUVRE.label))));
        salleRepository.save(new Salle(null,"E3004",4, new ArrayList<String>(Arrays.asList(EquipmentEnum.NEANT.label))));

    }
}
