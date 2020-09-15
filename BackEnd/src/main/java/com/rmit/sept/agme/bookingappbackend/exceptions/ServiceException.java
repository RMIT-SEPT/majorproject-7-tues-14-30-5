package com.rmit.sept.agme.bookingappbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for user repository-based exceptions
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
