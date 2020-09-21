package com.rmit.sept.agme.bookingappbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class AGMEService {
    @Id
    @NotBlank(message = "Service name cannot be empty")
    private String serviceName;
    @NotNull
    @Digits(integer = 5, fraction = 2, message = "Allowed values include 5 digits and 2 decimal places")
    private BigDecimal price;

    public AGMEService() {}

    public AGMEService(String serviceName, BigDecimal price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
