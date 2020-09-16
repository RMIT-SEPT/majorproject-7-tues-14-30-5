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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotBlank(message = "Customer username is required")
    private String customer;
    @NotBlank(message = "Worker username is required")
    private String worker;
    @NotBlank(message = "Service name is required")
    private String service;

    public CreateBookingRequest(Date time, Date date, String customer, String worker, String service) {
        this.time = time;
        this.date = date;
        this.customer = customer;
        this.worker = worker;
        this.service = service;
    }

    public Date getTime() {
        return time;
    }

    public Date getDate() {
        return date;
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
