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
    @Autowired
    private LoginService loginService;
    @MockBean
    private UserRepository repository;

    @BeforeAll
    void setUp() {
        User user = new User("Username1","Password1","PersonName","ContactNo");
        repository.save(user);
        userService.saveOrUpdateUser(user);
    }

    @Test
    public void passCredentialCheck() {
        Assert.assertTrue(loginService.validateLogin("Username1", "Password1"));
       // when(repository.save(user2)).thenReturn(user2);
        //Assert.assertEquals(user, userService.addUser(user));
        //assertThat(loginService.validateLogin("user_person","password_person")).isTrue();




    }

}
