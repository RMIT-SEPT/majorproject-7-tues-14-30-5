package com.rmit.sept.agme.bookingappbackend.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmit.sept.agme.bookingappbackend.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Creating a new user; retrieving Https Response - Successfully")
    void _1_createNewUser_isCreated_CorrectDetails() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\",\"name\":\"PersonName\",\"contactNo\":\"123456789\",\"role\":\"customer\"}";

        mockMvc.perform(
                post("/api/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andExpect(status().isCreated())
                        .andReturn();
    }
}
