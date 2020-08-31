package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//import java.util.Iterator;
//import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates inputted login credentials
     * @param username Username entered in login form
     * @param password Password entered in login form
     * @return true if the entered login information has been successfully validated
     */
    public boolean validateLogin(String username, String password) {
        boolean validated = false;

        //Debugging code primarily for LoginServiceTest - Look at running console when testing
        Iterable<User> all = userRepository.findAll();
        System.out.println("\nUsernames are as follows, if nothing is displayed below then there are no users in the database.\n");
        for (User users : all) {
            System.out.println(users.getUsername());
        }

        Optional<User> userOpt = userRepository.findById(username);

        //Debugging code primarily for LoginServiceTest- Look at running console when testing
        if (!userOpt.isPresent()) {
            System.out.println("\n=====\nRepository did not find a user\n=====\n");
        }

        if (userOpt.isPresent() && userOpt.get().getUsername().equals(username) && userOpt.get().getPassword().equals(password)) {
            validated = true;
        }

        return validated;
    }
}
