package com.rmit.sept.agme.bookingappbackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class for request '/api/login'
 */
public class LoginRequest {
    @NotBlank(message = "Username required")
    private String username;
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
        return this.password;
    }
}
