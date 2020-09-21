package com.rmit.sept.agme.bookingappbackend.web;

import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import com.rmit.sept.agme.bookingappbackend.services.AGMEServiceService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

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
public class AGMEServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AGMEServiceService agmeServiceService;

    private AGMEService agmeService1;

    @BeforeAll
    void setUp() {
        agmeService1 = new AGMEService("ServiceName", new BigDecimal("10.50"));
    }

    @AfterEach
    void cleanUp() {
        agmeServiceService.deleteService("ServiceName");
    }

    @Test
    @DisplayName("createNewService: Successfully creates a new service")
    void _1_createNewService_isCreated_CorrectDetails() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":10.50}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createNewService: Service already exists")
    void _2_createNewService_isBadRequest_CorrectDetails() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":10.50}";

        agmeServiceService.addService(agmeService1);

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("createNewService: Service Name is empty")
    void _3_createNewService_isBadRequest_ServiceNameEmpty() throws Exception {
        String json = "{\"serviceName\":\"\",\"price\":10.50}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("createNewService: Service Price is empty")
    void _4_createNewService_isBadRequest_PriceEmpty() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("createNewService: Price larger than 5 digits")
    void _5_createNewService_isBadRequest_Price6Digits() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":999999.00}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("createNewService: Price at 5 digits")
    void _6_createNewService_isCreated_Price5Digits() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":99999.00}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createNewService: Price has 0 decimal places")
    void _7_createNewService_isCreated_Price0DecimalPlace() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":10}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createNewService: Price has 1 decimal places")
    void _8_createNewService_isCreated_Price1DecimalPlace() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":0.1}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createNewService: Price has 2 decimal places")
    void _9_createNewService_isCreated_Price2DecimalPlace() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":0.12}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createNewService: Price has more than 2 decimal places")
    void _10_createNewService_isBadRequest_Price3DecimalPlace() throws Exception {
        String json = "{\"serviceName\":\"ServiceName\",\"price\":0.123}";

        mockMvc.perform(
                post("/api/service/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }
}
