package com.rmit.sept.agme.bookingappbackend.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Class for request '/api/booking/create'
 */
public class CreateBookingRequest {

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private Date dateTime;
    @NotBlank(message = "Customer username is required")
    private String customer;
    @NotBlank(message = "Worker username is required")
    private String worker;
    @NotBlank(message = "Service name is required")
    private String service;

    public CreateBookingRequest(Date dateTime, String customer, String worker, String service) {
        this.dateTime = dateTime;
        this.customer = customer;
        this.worker = worker;
        this.service = service;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getCustomer() {
        return customer;
    }

    public String getWorker() {
        return worker;
    }

    public String getService() {
        return service;
    }
}
