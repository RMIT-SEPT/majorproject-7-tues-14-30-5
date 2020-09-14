package com.rmit.sept.agme.bookingappbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Service service;
    private BigDecimal cost;

    private boolean completed;
    private boolean paid;

    public Booking(Date time, Date date, User worker, User customer, Service service, BigDecimal cost) {
        this.time = time;
        this.date = date;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
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
