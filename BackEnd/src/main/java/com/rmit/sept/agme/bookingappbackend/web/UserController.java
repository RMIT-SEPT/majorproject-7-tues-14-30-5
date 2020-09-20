package com.rmit.sept.agme.bookingappbackend.web;

import com.rmit.sept.agme.bookingappbackend.exceptions.UserException;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.requests.UpdateDetailsRequest;
import com.rmit.sept.agme.bookingappbackend.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Registers a new user into UserRepository
     * @param user The prospective user
     * @param result Validation results
     * @return ResponseEntity of added user if successful - Otherwise field errors or exception message
     */
    @PostMapping(value = "/registration")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        try {
            User user1 = userService.addUser(user);
            return new ResponseEntity<User>(user1, HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Updates a current user's details.
     * @param updateDetailsRequest Request form with all necessary/optional details to change in UserRepository.
     * @param result Validation results.
     * @return ResponseEntity of edited user if successful - Otherwise field errors or exception message.
     */
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateDetailsRequest updateDetailsRequest, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        try {
            return new ResponseEntity<User>(userService.updateUser(updateDetailsRequest.getUsername(), updateDetailsRequest.getPassword(),
                                                                   updateDetailsRequest.getFirstName(), updateDetailsRequest.getLastName(),
                                                                   updateDetailsRequest.getAddress(), updateDetailsRequest.getContactNo()),
                                                                   HttpStatus.CREATED);
        } catch (UserException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
