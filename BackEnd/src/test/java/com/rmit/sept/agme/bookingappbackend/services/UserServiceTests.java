package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.exceptions.UserException;
import com.rmit.sept.agme.bookingappbackend.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static org.junit.Assert.*;

/*
 * @Test
 * @DisplayName("Description of Test")
 * void _testNum_methodTesting_ExpectedValue_Input() {}
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    private User user1;
    private User user2;
    private User user3;

    @BeforeAll
    void setUp() {
        user1 = new User("Username","Password", "PersonName", "0404040404", "customer");
        user2 = new User("Username","Password", "PersonName", "Hello", "customer");
        user3 = new User("Username","Password", "PersonName", "0404040404", "customa");
    }

    @AfterEach
    void cleanUp () {
        userService.deleteUser(user1.getUsername());
        userService.deleteUser(user2.getUsername());
        userService.deleteUser(user3.getUsername());
    }

    @Test
    @DisplayName("findUser: Successfully finds a user")
    void _1_findUser_true_user1() {
        userService.addUser(user1);
        assertTrue(sameUser(user1, userService.findUser(user1.getUsername())));
    }

    @Test
    @DisplayName("findUser: Does not successfully find a user")
    void _2_findUser_noUserWithThatUsername_Null() {
        assertNull(userService.findUser(user1.getUsername()));
    }

    @Test
    @DisplayName("addUser: Entering in a new user - Successfully")
    void _1_addUser_true_user1() {
        User serviceUser = userService.addUser(user1);
        assertTrue(sameUser(user1, serviceUser));
    }

    @Test
    @DisplayName("addUser: Entering a new user - User already exists")
    void _2_addUser_sameUsernameThrowsException_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->userService.addUser(user1));

        String expectedMessage = "Username is not available. Please pick a different one.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("addUser: Contact number is incorrect")
    void _3_addUser_contactNoNotNumbersThrowsException_thenSucceedsMessage() {
        Exception exception = assertThrows(UserException.class, ()->userService.addUser(user2));

        String expectedMessage = "Hello is not a valid contact number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("addUser: Role is incorrect (customa)")
    void _4_addUser_roleCustomaIncorrectThrowsException_thenSucceedsMessage() {
        Exception exception = assertThrows(UserException.class, ()->userService.addUser(user3));

        String expectedMessage = "customa is not a valid role";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("updateUser: Updating user details")
    void _1_updateUser_false_user1() {
        userService.addUser(user1);
        User newDetailsUser = userService.updateUser("Username", "newPassword", "newName",
                "newLastName", "newAddress", "0505050505");
        Assert.assertFalse(sameUser(user1, newDetailsUser));
    }

    @Test
    @DisplayName("updateUser: Password too short")
    void _2_updateUser_passwordCheckLessThan6CharsThrowsException_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->
                userService.updateUser("Username", "pw", "newName",
                "newLastName", "newAddress", "0505050505"));

        String expectedMessage = "Information is not valid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("updateUser: Password too long")
    void _3_updateUser_passwordCheckMoreThan20CharsThrowsException_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->
                userService.updateUser("Username", "newpasswordishellalongandshouldbelong", "newName",
                "newLastName", "newAddress", "0505050505"));

        String expectedMessage = "Information is not valid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("updateUser: First name is blank")
    void _4_updateUser_firstNameIsEmptyThrowsException_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->
                userService.updateUser("Username", "newPassword", "",
                "newLastName", "newAddress", "0505050505"));

        String expectedMessage = "Information is not valid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("updateUser: Last name is empty and OK")
    void _5_updateUser_lastNameIsEmpty_validAndTrue() {
        userService.addUser(user1);
        User newUser = userService.updateUser("Username", "newPassword", "newName",
                "", "newAddress", "0505050505");

        String actualName = userService.findUser("Username").getName();
        String expectedName = "newName";

        assertTrue(actualName.contains(expectedName));

    }

    @Test
    @DisplayName("updateUser: Address is empty and OK")
    void _6_updateUser_addressIsEmpty_validAndTrue() {
        userService.addUser(user1);
        User newUser = userService.updateUser("Username", "newPassword", "newFirstName",
                "newLastName", "", "0505050505");

        String actualAddress = userService.findUser("Username").getAddress();
        String expectedAddress = "";

        assertTrue(actualAddress.contains(expectedAddress));

    }

    @Test
    @DisplayName("updateUser: Contact Number is incorrect")
    void _7_updateUser_contactNoIsIncorrectThrowsException_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->
                userService.updateUser("Username", "newPassword", "newFirstName",
                        "newLastName", "newAddress", "notANumber"));

        String expectedMessage = "Information is not valid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("updateUser: User does not exist in database")
    void _8_updateUser_userDoesNotExist_thenSucceedsMessage() {
        userService.addUser(user1);
        Exception exception = assertThrows(UserException.class, ()->
                userService.updateUser("noUserExists", "newPassword", "newName",
                        "newLastName", "newAddress", "notANumber"));

        String expectedMessage = "User noUserExists does not exist.";
        String actualMessage = exception.getMessage();

        System.out.println(actualMessage);

        assertTrue(actualMessage.contains(expectedMessage));
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
