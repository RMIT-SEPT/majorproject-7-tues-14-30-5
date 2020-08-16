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

    UserService  userService;

    /*
        Incomplete; I'm not sure if a standalone method like this is needed, feel free
        to delete if you have no use for it/no reason to warrant completion.
        - Matt D
     */
//    public List<User> findAllByUsername(String username) {
//        Iterator<User> allUsers = userRepository.findAll().iterator();
//
//        while (allUsers.hasNext()) {
//            if(allUsers.next().getUsername().equals(username)) {
//
//            }
//        }
//    }

    /**
     * Validates inputted login credentials
     * @param username Username entered in login form
     * @param password Password entered in login form
     * @return true if the entered login information has been successfully validated
     */
    public boolean validateLogin(String username, String password, User user) {
        boolean validated = false;

        if (((ArrayList) userService.getUsers()).size() >= 5) {
            Optional<User> userOptional = userRepository.findById(username);

            if(userOptional.isPresent()) {
                user = userOptional.get();

                if (user.getPassword().equals(password)) {
                    validated = true;
                }
            }
        }

        return validated;
    }
}
