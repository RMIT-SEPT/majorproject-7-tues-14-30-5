package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.BookingAppBackendApplication;
import com.rmit.sept.agme.bookingappbackend.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = BookingAppBackendApplication.class)
class LoginServiceTests {

    LoginService loginService = new LoginService();
    UserService userService = new UserService();

    /*
        checkEmptyDB might not need to be here; specifications state that the database must have
        at least 5 customers in it. However, I do not know how to enforce it.
     */
//    @Test
//    public void checkEmptyDB() {
//        assertThat(loginService.validateLogin("someusername","somepassword")).isFalse();
//    }

    @BeforeAll
    void setUp() {
        User user = new User();
        user.setName("user_person");
        user.setPassword("password_person");

        userService.saveOrUpdateUser(user);
    }

    @Test
    public void passCredentialCheck() {
        assertThat(loginService.validateLogin("user_person","password_person")).isTrue();
    }

}
