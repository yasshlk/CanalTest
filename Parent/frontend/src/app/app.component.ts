import { Component } from '@angular/core';
import { ServiceReservationService } from './service/service-reservation.service';
import { Observable } from 'rxjs';
import { Meeting } from './entities/meeting';
import { Room } from './entities/room';
import { Reservation } from './entities/reservation';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'meetingPlannerProject';
  public meetingsData : Meeting[];
  public roomsData : Room[];
  public reservationsData : Reservation[];

  displayedColumnsRooms: string[] = ['id', 'name', 'capacity', 'equipement'];
  displayedColumnsMeetings: string[] = ['id', 'name', 'type', 'start_time','end_time','participant'];
  displayedColumnsReservations: string[] = ['id', 'date_reservation', 'salle', 'reunion','reserv_debut_time','reserv_fin_time'];


  constructor(private reservationService : ServiceReservationService) { }

  ngOnInit(): void {
    this.getAllRooms();
    this.getAllMeetings();
  }

  getAllMeetings(){
     this.reservationService.getAllMeetings().subscribe((data: any[])=>{ 
      this.meetingsData = data;
    }); 
  }

  getAllRooms(){
    this.reservationService.getAllRooms().subscribe((data: any[])=>{ 
     this.roomsData = data;
   }); 
 }

 faireReservation(){
  this.reservationService.makeReservationsMatch().subscribe((data: any[])=>{ 
   this.reservationsData = data;
 }); 
}
}
