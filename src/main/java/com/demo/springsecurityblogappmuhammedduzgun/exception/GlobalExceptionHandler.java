package com.demo.springsecurityblogappmuhammedduzgun.exception;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setMessage(ex.getMessage());
        apiErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEntityAlreadyExistsException(EntityAlreadyExistsException ex){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setMessage(ex.getMessage());
        apiErrorResponse.setStatus(HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleBadCredentialsException(BadCredentialsException ex){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setMessage(ex.getMessage());
        apiErrorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleAnyException(Exception ex){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setMessage(ex.getMessage());
        apiErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
