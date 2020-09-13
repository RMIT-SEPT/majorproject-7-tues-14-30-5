package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/*
 * @Test
 * @DisplayName("Description of Test")
 * void _testNum_methodTesting_ExpectedValue_Input() {}
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class LoginServiceTests {

    @Autowired
    private LoginService loginService;

    @Autowired
    UserRepository userRepository;

    private User user1;
    private User user2;
    private User user3;

    @BeforeAll
    void setUp() {
        user1 = new User("Username","Password", "PersonName", "0404040404", "customer");
        user2 = new User("Username","Password", "PersonName", "Hello", "customer");
        user3 = new User("Username","Password", "PersonName", "0404040404", "customa");
    }

    @Test
    @DisplayName("validateLogin: Successful login")
    void _1_validateLogin_successfulLogin_user1() {
        userRepository.save(user1);
        User loggedInUser = loginService.validateLogin(user1.getUsername(), user1.getPassword());
        assertTrue(sameUser(loggedInUser, user1));
    }

    /**
     * Helper function for test classes - Checks if two users have the same details
     * @param a First User
     * @param b Second User
     * @return True if they have the exact same data in their fields
     */
    private boolean sameUser(User a, User b) {
        if (a.getUsername().equals(b.getUsername()) && a.getPassword().equals(b.getPassword()) &&
                a.getName().equals(b.getName()) && a.getAddress().equals(b.getAddress()) &&
                a.getContactNo().equals(b.getContactNo()) && a.getRole().equals(b.getRole())) {
            return true;
        } else {
            return false;
        }
    }
}
