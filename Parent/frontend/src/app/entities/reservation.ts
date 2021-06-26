import { Time } from '@angular/common';
import { Room } from './room';
import { Meeting } from './meeting';


export class Reservation {

    id: number;
    heure_de_reservation: Date;
    salle: Room;
    reunion: Meeting;
    reserv_debut_time :Time;
    reserv_fin_time: Time;

}
