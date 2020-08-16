package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public User saveOrUpdateUser(User user) {

        // Business Logic

        return userRepository.save(user);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {

        userRepository.delete(user);
    }

    public Iterable<User> getUsers(){
        Iterable<User> users = userRepository.findAll();

        return users;
    }


}
