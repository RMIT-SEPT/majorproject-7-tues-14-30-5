package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest(classes = BookingAppBackendApplication.class)
public class UserTest {


    @Test
    public void testUsernameGettterSetter(){
        User testUser = new User();
        testUser.setUsername("Gav");
        Assert.assertEquals("Gav",testUser.getUsername());
    }

    @Test
    public void testPasswordGetterSetter(){
        User testUser = new User();
        testUser.setPassword("hello");
        Assert.assertEquals("hello",testUser.getPassword());
    }

    @Test
    public void testNameGetterSetter(){
        User testUser = new User();
        testUser.setName("Gav");
        Assert.assertEquals("Gav",testUser.getName());
    }

    @Test
    public void testAddressGetterSetter(){
        User testUser = new User();
        testUser.setAddress("4MalcomStreet");
        Assert.assertEquals("4MalcomStreet",testUser.getAddress());
    }

    @Test
    public void testContractNoGetterSetter(){
        User testUser = new User();
        testUser.setContactNo("8874385");
        Assert.assertEquals("8874385",testUser.getContactNo());
    }

    @Test
    public void testRoleGetterSetter(){
        User testUser = new User();
        testUser.setRole("Worker");
        Assert.assertEquals("Worker",testUser.getRole());
    }





}