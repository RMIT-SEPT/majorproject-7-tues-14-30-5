package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.BookingAppBackendApplication;
import com.rmit.sept.agme.bookingappbackend.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Autowired
    ApplicationContext context;

    @BeforeAll
    void setUp() {
        User user = new User();
        user.setName("user_person");
        user.setPassword("password_person");

//      UserRepository repo = context.getBean(UserRepository.class);
//      repo.save(user);

        userService.saveOrUpdateUser(user);

//        assertThat(user.getName(),"user_person")
    }

    @Test
    public void passCredentialCheck() {
        assertThat(loginService.validateLogin("user_person","password_person")).isTrue();
    }

}
