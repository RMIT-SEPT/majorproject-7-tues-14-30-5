package com.rmit.sept.agme.bookingappbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
 public class User {

    @Id
    @Size(min = 6, max = 20, message = "name must be longer than 6 characters")
    private String username;
    @Size(min = 6, max = 20, message = "Password must be longer than 6 characters")
    @NotBlank(message = "Password required")
    private String password;
    @NotBlank(message = "Name required")
    private String name;
    private String address;
    @NotBlank(message = "Contact number required")
    private String contactNo;
    @NotBlank(message = "Role must be specified")
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated_At;

    public User() {}

    public User(String username, String password, String name, String contactNo, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.contactNo = contactNo;
        this.role = role;
        this.address = "";
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String customerName) {
        this.name = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }

}
