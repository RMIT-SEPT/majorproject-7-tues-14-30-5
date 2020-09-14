package com.rmit.sept.agme.bookingappbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Service {
    @Id
    @NotBlank(message = "Service name cannot be empty")
    private String serviceName;
    @NotBlank(message = "Price is required")
    @Digits(integer = 5, fraction = 2, message = "Only 2 decimal places allowed for cents")
    private BigDecimal price;

    public Service() {}

    public Service(String serviceName, BigDecimal price) {
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
