import { Injectable } from '@angular/core';
import { HttpClient,HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceReservationService {

  private apiBaseUrl = environment.apiBaseUrl;
  private makeReservationMatch_Path = '/meeting/reserver';
  private getAllReservation_Path = '/meeting/reservations';
  private getAllMeeting_Path = '/meeting/reunions';
  private getAllRooms_Path = '/meeting/salles';
  private getAllReservationEquipment = '/meeting/buildHand';

  constructor(private httpClient: HttpClient) {

  }


  public makeReservationsMatch(){
    return this.httpClient.get( this.apiBaseUrl + this.makeReservationMatch_Path);
  }

  public getAllReservations(){
    return this.httpClient.get( this.apiBaseUrl + this.getAllReservation_Path);
  }

  public getAllMeetings(){
    return this.httpClient.get( this.apiBaseUrl + this.getAllMeeting_Path);
  }

  public getAllRooms(){
    return this.httpClient.get( this.apiBaseUrl + this.getAllRooms_Path);
  }
}
