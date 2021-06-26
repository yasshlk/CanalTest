package com.yshlk.meetingplanner.exceptions;
/* Created By yassine */


import com.yshlk.meetingplanner.utils.ApiErrorsObject;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message  = "Method Not Supported";
        ApiErrorsObject errors = new ApiErrorsObject(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message  = "Media Not Supported";
        ApiErrorsObject errors = new ApiErrorsObject(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Path Variable Missing";
        ApiErrorsObject errors = new ApiErrorsObject(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Mismatch of type";
        ApiErrorsObject errors = new ApiErrorsObject(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Request Body Not Readable";
        ApiErrorsObject errors = new ApiErrorsObject(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

}
