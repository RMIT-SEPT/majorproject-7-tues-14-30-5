package com.rmit.sept.agme.bookingappbackend.web;

import com.rmit.sept.agme.bookingappbackend.repositories.UserRepository;
import com.rmit.sept.agme.bookingappbackend.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    @AfterEach
    void cleanUp() {
        service.deleteUser("Username");
    }

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
}
