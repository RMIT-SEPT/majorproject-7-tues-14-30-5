package com.rmit.sept.agme.bookingappbackend.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.requests.LoginRequest;
import com.rmit.sept.agme.bookingappbackend.services.LoginService;
import com.rmit.sept.agme.bookingappbackend.services.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/api/login")
    public ResponseEntity<?> validate(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) throws JsonProcessingException {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Boolean login = loginService.validateLogin(username, password);

        return new ResponseEntity<Boolean>(login, HttpStatus.CREATED);
    }
}
