import { Time } from '@angular/common';

export class Meeting {

    id: number;
    name: String;
    type: String;
    start_time: Time;
    end_time: Time;
    participant : number;
}
