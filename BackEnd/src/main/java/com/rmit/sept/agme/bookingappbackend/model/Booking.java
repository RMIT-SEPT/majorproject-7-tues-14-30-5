package com.rmit.sept.agme.bookingappbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @JsonFormat(pattern = "HH:mm")
    private Date time;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL) // What happens to parent entity will be applied to
    private User worker;
    @ManyToOne(cascade = CascadeType.ALL)
    private User customer;

    private String service;
    private double cost;

    private boolean completed;
    private boolean paid;


    public Booking() {
        this.completed = false;
        this.paid = false;
    }

    public Booking(User worker) {
        this.worker = worker;
        this.completed = false;
        this.paid = false;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
