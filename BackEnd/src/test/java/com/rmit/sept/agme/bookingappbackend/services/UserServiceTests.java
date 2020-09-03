package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.BookingAppBackendApplication;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import com.rmit.sept.agme.bookingappbackend.services.LoginService;
import com.rmit.sept.agme.bookingappbackend.services.UserService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = BookingAppBackendApplication.class)
public class UserServiceTests {


    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository repository;

    User user;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;

    LoginService loginService;
    @BeforeAll
    void setUp() {
//         user = new User("aaaaa","qwe123");
//        user2 = new User("aaaaaa","qwe123");
//        user3 = new User("aaaaa","qwe123");
//        user4 = new User("aaaaaa","qwe123");
//        user5 = new User("aaaaa","qwe123");
//        user6 = new User("aaaaaa","qwe123");
         loginService = new LoginService();
    }

    @Test
    public void getUsersTesting(){

//        when(repository.findAll()).thenReturn(Stream.of(new User("AK","AK12345")
//               ,new User("AK","AK12345")).collect(Collectors.toList()));
//
//       Assert.assertEquals(2,  ((ArrayList) userService.getUsers()).size());

    }
    @Test
    public void addUsersTesting(){
        when(repository.save(user)).thenReturn(user);
        when(repository.save(user2)).thenReturn(user2);
        Assert.assertEquals(user, userService.addUser(user));
        Assert.assertEquals(user2, userService.addUser(user2));

    }

    @Test
    public void deleteUsersTesting(){
        userService.deleteUser(user);
        userService.deleteUser(user2);
        verify(repository, times(1)).delete(user);
        verify(repository, times(1)).delete(user2);
    }

  /*  @Test
    public void passCredentialCheck() {
        // when(repository.save(user2)).thenReturn(user2);
        // Assert.assertEquals(user, userService.addUser(user));
        // user.setName("user_person");
        //  user.setPassword("password_person");
        //  userService.saveOrUpdateUser(user);
        when(repository.save(user)).thenReturn(user);
        when(repository.save(user2)).thenReturn(user2);
        when(repository.save(user3)).thenReturn(user3);
        when(repository.save(user4)).thenReturn(user4);
        when(repository.save(user5)).thenReturn(user5);
        when(repository.save(user6)).thenReturn(user6);
        userService.addUser(user);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);
        userService.addUser(user6);
      //  when(repository.findAll()).thenReturn(Stream.of(new User("AK","AK12345")
               // ,new User("AK","AK12345") ,new User("AK","AK12345")
               // ,new User("AK","AK12345") ,new User("AK","AK12345")).collect(Collectors.toList()));
        Assert.assertEquals(true, loginService.validateLogin("aaaaa","qwe123", user));
        Assert.assertEquals(true,loginService.validateLogin("aaaaaa","qwe123", user2));
        Assert.assertEquals(true,loginService.validateLogin("aaaaa","qwe123", user3));
        Assert.assertEquals(true,loginService.validateLogin("aaaaaa","qwe123", user4));
        Assert.assertEquals(true, loginService.validateLogin("aaaaa","qwe123", user5));
        Assert.assertEquals(true, loginService.validateLogin("aaaaaa","qwe123", user6));


       // assertThat(loginService.validateLogin("AK","AK12345", user)).isTrue();

    }
*/


}
