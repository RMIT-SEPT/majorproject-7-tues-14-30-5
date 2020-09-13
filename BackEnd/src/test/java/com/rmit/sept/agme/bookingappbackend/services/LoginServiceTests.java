package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import com.rmit.sept.agme.bookingappbackend.testUtilities.TestUtilities;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
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
    private UserRepository userRepository;

    private User user1;

    @BeforeAll
    void setUp() {
        user1 = new User("Username","Password", "PersonName", "0404040404", "customer");
        userRepository.save(user1);
    }

    @AfterAll
    void cleanUp() {
        if (userRepository.existsById(user1.getUsername())) {
            userRepository.deleteById(user1.getUsername());
        }
    }

    @Test
    @DisplayName("validateLogin: Successful login")
    void _1_validateLogin_successfulLogin_user1() {
        User loggedInUser = loginService.validateLogin("Username", "Password");
        assertTrue(TestUtilities.sameUser(loggedInUser, user1));
    }

    @Test
    @DisplayName("validateLogin: Username wrong")
    void _2_validateLogin_userNameWrong_Usernam() {
        User loggedInUser = loginService.validateLogin("Usernam", "Password");
        assertNull(loggedInUser);
    }

    @Test
    @DisplayName("validateLogin: Password wrong")
    void _3_validateLogin_userNameWrong_Passwor() {
        User loggedInUser = loginService.validateLogin("Username", "Passwor");
        assertNull(loggedInUser);
    }
}
