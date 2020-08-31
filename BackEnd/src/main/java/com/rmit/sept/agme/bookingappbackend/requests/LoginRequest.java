package com.rmit.sept.agme.bookingappbackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {
    @Size(min = 6, max = 20, message = "Username must be longer than 6 characters")
    @NotBlank(message = "Username required")
    private String username;
    @Size(min = 6, max = 20, message = "Password must be longer than 6 characters")
    @NotBlank(message = "Password required")
    private String password;

    public LoginRequest(String usernameRequest, String passwordRequest) {
        this.username = usernameRequest;
        this.password = passwordRequest;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return  this.password;
    }
}
