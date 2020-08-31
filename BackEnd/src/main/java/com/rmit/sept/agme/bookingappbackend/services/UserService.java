package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import com.rmit.sept.agme.bookingappbackend.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public User saveOrUpdateUser(User user) {

        // Business Logic


        return userRepository.save(user);
    }

    public User addUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserException(user.getUsername() + "' is not available. Please pick a different one.");
        }
        else {
            return userRepository.save(user);
        }
    }

    public User updateUser(String username, String password, String firstName, String lastName, String address, String contactNo) {
        Optional<User> userOpt = userRepository.findById(username);
        if (userOpt.isPresent()) {
            if (validateUpdateDetails(password, firstName, contactNo)) {
                User updateUser = userOpt.get();
                updateUser.setPassword(password);
                updateUser.setName(firstName + " " + lastName);
                updateUser.setAddress(address);
                updateUser.setContactNo(contactNo);
                return userRepository.save(updateUser);
            } else {
                throw new UserException("Information is not valid");
            }
        } else {
            throw new UserException("User " + username + " does not exist.");
        }
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public Iterable<User> getUsers(){
        Iterable<User> users = userRepository.findAll();

        return users;
    }

    private boolean validateUpdateDetails(String password, String firstName, String contactNo) {
        if (password.length() >= 6 && password.length() <= 20) {
            if (!firstName.isEmpty()) {
                if (contactNo.matches("[0-9]+")) {
                    return true;
                }
            }
        }
        return false;
    }
}
