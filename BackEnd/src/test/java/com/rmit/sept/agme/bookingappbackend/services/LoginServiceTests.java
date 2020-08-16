package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.BookingAppBackendApplication;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = BookingAppBackendApplication.class)
class LoginServiceTests {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository repository;
    LoginService loginService = new LoginService();
   // UserService userService = new UserService();

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
       // User user = new User();
        User user = new User("aaaaa","qwe123");
        User user2 = new User("aaaaaa","qwe123");
        user.setName("user_person");
        user.setPassword("password_person");

        userService.saveOrUpdateUser(user);
    }

    @Test
    public void passCredentialCheck() {
       // when(repository.save(user2)).thenReturn(user2);
        //Assert.assertEquals(user, userService.addUser(user));
        //assertThat(loginService.validateLogin("user_person","password_person")).isTrue();




    }

}
