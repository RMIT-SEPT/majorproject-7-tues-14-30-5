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
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private User user1;

    @BeforeAll
    void setUp() {
        user1 = new User("Username", "Password", "PersonName", "0404040404", "customer");
    }

    @AfterEach
    void cleanUp() {
        userService.deleteUser(user1.getUsername());
    }

    @Test
    @DisplayName("validate: Successfully log in")
    void _1_validate_isOk_validCredentials() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("validate: Cannot log in - User doesn't exist")
    void _2_validate_isBadRequest_validCredentials() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Password\"}";

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("validate: Cannot log in - Username misspelt")
    void _3_validate_isBadRequest_UsernameWrong() throws Exception {
        String json = "{\"username\":\"Usermane\",\"password\":\"Password\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("validate: Cannot log in - Password misspelt")
    void _4_validate_isBadRequest_PasswordWrong() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"Pasworl\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("validate: Cannot log in - Username empty")
    void _5_validate_isBadRequest_UsernameEmpty() throws Exception {
        String json = "{\"username\":\"\",\"password\":\"Password\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("validate: Cannot log in - Password empty")
    void _6_validate_isBadRequest_PasswordEmpty() throws Exception {
        String json = "{\"username\":\"Username\",\"password\":\"\"}";

        userService.addUser(user1);

        mockMvc.perform(
                post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }
}
