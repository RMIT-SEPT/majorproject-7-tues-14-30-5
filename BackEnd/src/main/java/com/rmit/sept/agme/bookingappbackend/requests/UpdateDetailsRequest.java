package com.rmit.sept.agme.bookingappbackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class for request '/api/user/update'
 */
public class UpdateDetailsRequest {
    @Size(min = 6, max = 20, message = "Username must be longer than 6 characters")
    @NotBlank(message = "Username required")
    private String username;
    @Size(min = 6, max = 20, message = "Password must be longer than 6 characters")
    @NotBlank(message = "Password required")
    private String password;
    @NotBlank(message = "First name is required")
    private String firstName;
    private String lastName;
    private String address;
    @NotBlank(message = "Contact Number is required")
    private String contactNo;

    public UpdateDetailsRequest (String username, String password, String firstName, String lastName, String address, String contactNo) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }
}
