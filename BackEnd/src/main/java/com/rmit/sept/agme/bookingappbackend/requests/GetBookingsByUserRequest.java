package com.rmit.sept.agme.bookingappbackend.requests;

import javax.validation.constraints.NotBlank;

public class GetBookingsByUserRequest {

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @NotBlank(message = "Username required")
    private String user;

    public GetBookingsByUserRequest(String user) {
        this.user = user;
    }


}
