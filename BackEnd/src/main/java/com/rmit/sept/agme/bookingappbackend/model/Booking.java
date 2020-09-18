package com.rmit.sept.agme.bookingappbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private Date dateTime;

    @ManyToOne(cascade = CascadeType.ALL) // What happens to parent entity will be applied to
    private User worker;
    @ManyToOne(cascade = CascadeType.ALL)
    private User customer;

    @ManyToOne(cascade = CascadeType.ALL)
    private AGMEService service;
    @Digits(integer = 6, fraction = 2, message = "Service cost is max 999999.99")
    private BigDecimal cost;

    private boolean completed;
    private boolean paid;

    public Booking(Date dateTime, User worker, User customer, AGMEService service, BigDecimal cost) {
        this.dateTime = dateTime;
        this.worker = worker;
        this.customer = customer;
        this.service = service;
        this.cost = cost;
        this.completed = false;
        this.paid = false;
    }

    public Booking() {
        this.completed = false;
        this.paid = false;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public AGMEService getService() {
        return service;
    }

    public void setService(AGMEService service) {
        this.service = service;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
