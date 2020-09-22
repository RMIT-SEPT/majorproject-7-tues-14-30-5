package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import com.rmit.sept.agme.bookingappbackend.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import static com.rmit.sept.agme.bookingappbackend.constants.Constants.CUSTOMER;
import static com.rmit.sept.agme.bookingappbackend.constants.Constants.WORKER;
import static com.rmit.sept.agme.bookingappbackend.constants.Constants.ADMIN;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Attempts to find a certain user in UserRepository.
     * @param username The primary key to search UserRepository with.
     * @return User that matches the username - Otherwise NULL.
     */
    public User findUser(String username) {
        Optional<User> userOpt = userRepository.findById(username);
        return userOpt.orElse(null);
    }

    /**
     * Attempts to add a new user to UserRepository.
     * @param user The user to add to UserRepository.
     * @return The same user if it succeeds in adding - Otherwise throw an UserException.
     */
    public User addUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserException(user.getUsername() + " is not available. Please pick a different one.");
        } else if (!validateContactNoRegex(user.getContactNo())) {
            throw new UserException(user.getContactNo() + " is not a valid contact number.");
        } else if (!validateRole(user.getRole())) {
            throw new UserException(user.getRole() + " is not a valid role");
        } else {
            return userRepository.save(user);
        }
    }

    /**
     * Attempts to update the information of a current user in UserRepository.
     * @param username The primary key for finding a user.
     * @param password The new password to change into.
     * @param firstName The new first name to change into (firstName + Lastname).
     * @param lastName The new last name to change into (firstName + Lastname).
     * @param address The new address to change into.
     * @param contactNo The new contact number to change into.
     * @return The same user with updates details if it succeeds - Otherwise throw an UserException.
     */
    public User updateUser(String username, String password, String firstName, String lastName, String address, String contactNo) {
        Optional<User> userOpt = userRepository.findById(username);
        if (userOpt.isPresent()) {
            if (validateUpdateDetails(password, firstName, contactNo)) {
                User newUserDetails = userOpt.get();
                newUserDetails.setPassword(password);
                if (lastName != null && !lastName.isEmpty()) {
                    newUserDetails.setName(firstName + " " + lastName);
                } else {
                    newUserDetails.setName(firstName);
                }
                newUserDetails.setAddress(address);
                newUserDetails.setContactNo(contactNo);
                return userRepository.save(newUserDetails);
            } else {
                throw new UserException("Information is not valid");
            }
        } else {
            throw new UserException("User " + username + " does not exist.");
        }
    }

    /**
     * HELPER: Validates if the fields to enter are valid/present before proceeding with user updating.
     * @param password The potential new password of the user.
     * @param firstName The potential new first name of the user.
     * @param contactNo The potential new contact number of the user.
     * @return True if all parameters are valid for updating.
     */
    private boolean validateUpdateDetails(String password, String firstName, String contactNo) {
        if (password.length() >= 6 && password.length() <= 20) {
            if (!firstName.isEmpty()) {
                return validateContactNoRegex(contactNo);
            }
        }
        return false;
    }

    /**
     * HELPER: Validates contact number for regex
     * @param contactNo Contact number to validate
     * @return True if contactNo passes regex matching [0-9]+
     */
    private boolean validateContactNoRegex(String contactNo) {
        return contactNo.matches("[0-9]+");
    }

    /**
     * HELPER: Validates role name if in one of three ('customer', 'worker' or 'admin').
     * NOTE: NOT EXPECTED TO BE ABLE TO RETURN FALSE IN NORMAL FRONT END USAGE BUT IS FOR ADMIN
     * @param role Role name to validate
     * @return True if the role name fits in one of the 3 roles
     */
    private boolean validateRole(String role) {
        return role.equals(CUSTOMER) || role.equals(WORKER) || role.equals(ADMIN);
    }

    /**
     * HELPER: Used for cleanup in UserServiceTests
     * @param username The username to find and delete
     */
    public void deleteUser(String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
        }
    }
}
