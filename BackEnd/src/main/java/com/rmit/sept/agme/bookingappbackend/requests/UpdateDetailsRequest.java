package com.rmit.sept.agme.bookingappbackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateDetailsRequest {
    @Size(min = 6, max = 20, message = "Username must be longer than 6 characters")
    @NotBlank(message = "Username required")
    private String username;
    @Size(min = 6, max = 20, message = "Password must be longer than 6 characters")
    @NotBlank(message = "Password required")
    private String password;
    @NotBlank
    private String firstName;
    private String lastName;
    private String address;
    @NotBlank
    private String contactNo;

    public UpdateDetailsRequest (String username, String password, String firstName, String lastName, String address, String ) {

    }
}
