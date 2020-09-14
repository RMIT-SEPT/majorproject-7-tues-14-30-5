package com.rmit.sept.agme.bookingappbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {
    @Id
    private String serviceName;
}
