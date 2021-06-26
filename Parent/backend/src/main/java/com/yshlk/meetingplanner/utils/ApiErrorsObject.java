package com.yshlk.meetingplanner.utils;
/* Created By yassine */

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiErrorsObject {

    String message;
    HttpStatus status;
    LocalDateTime timestamp;
}
