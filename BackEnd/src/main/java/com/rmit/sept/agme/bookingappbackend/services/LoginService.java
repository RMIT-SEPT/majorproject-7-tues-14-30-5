package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates inputted login credentials.
     * @param username Username entered in login form.
     * @param password Password entered in login form.
     * @return Actual user if the entered login information has been successfully validated - Otherwise null.
     */
    public User validateLogin(String username, String password) {
        Optional<User> userOpt = userRepository.findById(username);
        if (userOpt.isPresent() && userOpt.get().getUsername().equals(username) && userOpt.get().getPassword().equals(password)) {
            return userOpt.get();
        } else {
            return null;
        }
    }
}
