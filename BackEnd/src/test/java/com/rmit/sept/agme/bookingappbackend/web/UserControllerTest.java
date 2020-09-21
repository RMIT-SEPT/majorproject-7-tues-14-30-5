package com.rmit.sept.agme.bookingappbackend.web;

import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * @Test
 * @DisplayName("Description of Test")
 * void _testNum_methodTesting_ExpectedValue_Input() {}
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private User user1;

    @BeforeAll
    void setUp() {
        user1 = new User("Username", "Password", "PersonName", "123456789", "customer", "Address");
    }

    @AfterEach
    void cleanUp() {
        userService.deleteUser("Username");
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Creating a new customer w/out address; retrieving Https Response - Successfully")
    void _1_createNewUser_isCreated_CorrectDetailsNoAddressCustomer() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Creating a new customer w/address; retrieving Https Response - Successfully")
    void _2_createNewUser_isCreated_CorrectDetailsCustomer() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\",\"address\":\"Address\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Creating a new worker w/out address; retrieving Https Response - Successfully")
    void _3_createNewUser_isCreated_CorrectDetailsNoAddressCustomer() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"worker\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Creating a new admin w/out address; retrieving Https Response - Successfully")
    void _4_createNewUser_isCreated_CorrectDetailsNoAddressCustomer() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"admin\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Missing username")
    void _5_createNewUser_isBadRequest_MissingUsername() throws Exception {
        String json = "{\"username\":\"\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Username below 6 characters")
    void _6_createNewUser_isBadRequest_Username5Characters() throws Exception {
        String json = "{\"username\":\"Usern\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Username above 20 characters")
    void _7_createNewUser_isBadRequest_Username21Characters() throws Exception {
        String json = "{\"username\":\"UsernameIsAboveTwenty\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Missing password")
    void _8_createNewUser_isBadRequest_MissingPassword() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Password below 6 characters")
    void _9_createNewUser_isBadRequest_Password5Characters() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Passw\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Password above 20 characters")
    void _10_createNewUser_isBadRequest_Password21Characters() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"PasswordIsAboveTwenty\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Name is blank")
    void _11_createNewUser_isBadRequest_NameBlank() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Contact Number is blank")
    void _12_createNewUser_isBadRequest_ContactNumBlank() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Contact Number is not made of numbers")
    void _13_createNewUser_isBadRequest_ContactNumNotNum() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"ThisIsNotNumbers\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Role is blank")
    void _14_createNewUser_isBadRequest_RoleBlank() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: Role is not correct")
    void _15_createNewUser_isBadRequest_RoleIscustoma() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customa\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("createNewUser: User already exists")
    void _16_createNewUser_isBadRequest_UsernameAlreadyInDB() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Successfully update details")
    void _1_updateUser_isCreated_CorrectDetailsJson() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: User does not exist in database")
    void _2_updateUser_isBadRequest_CorrectDetailsJson() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Username is empty")
    void _3_updateUser_isBadRequest_UsernameEmpty() throws Exception {
        String json = "{\"username\":\"\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Username is below 6 characters")
    void _4_updateUser_isBadRequest_Username5Characters() throws Exception {
        String json = "{\"username\":\"Usern\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Username is above 20 characters")
    void _5_updateUser_isBadRequest_Username21Characters() throws Exception {
        String json = "{\"username\":\"UsernameIsAboveTwenty\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Password is empty")
    void _6_updateUser_isBadRequest_PasswordEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Password is below 6 characters")
    void _7_updateUser_isBadRequest_Password5Characters() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPa\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Password is above 20 characters")
    void _8_updateUser_isBadRequest_Password21Characters() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPasswordIsAboveTwe\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: First name is empty")
    void _9_updateUser_isBadRequest_FirstNameEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Last name is empty")
    void _10_updateUser_isCreated_LastNameEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"\",\"address\":\"NewAddress\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Address is empty")
    void _11_updateUser_isCreated_AddressEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"\",\"contactNo\":\"987654321\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Contact Number is empty")
    void _12_updateUser_isBadRequest_ContactNumberEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    //Author: Matt D
    @Test
    @DisplayName("updateUser: Contact Number is not numerical")
    void _13_updateUser_isBadRequest_ContactNumberNotNumber() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"NewPassword\",\"firstName\":\"PersonNew\",\"lastName\":\"NamePerson\",\"address\":\"NewAddress\",\"contactNo\":\"NotANumber\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }
}
