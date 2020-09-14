package com.rmit.sept.agme.bookingappbackend.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Class for request '/api/booking/create'
 */
public class CreateBookingRequest {
    @JsonFormat(pattern = "HH:mm")
    private Date time;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private String customer;
    private String worker;
    private String service;
}
