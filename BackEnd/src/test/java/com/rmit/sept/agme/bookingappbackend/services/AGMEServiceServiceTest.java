package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.exceptions.ServiceException;
import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import com.rmit.sept.agme.bookingappbackend.testUtilities.TestUtilities;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import static org.junit.Assert.*;

/*
 * @Test
 * @DisplayName("Description of Test")
 * void _testNum_methodTesting_ExpectedValue_Input() {}
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class AGMEServiceServiceTest {

    @Autowired
    private AGMEServiceService agmeServiceService;

    private AGMEService service1;

    @BeforeAll
    void setUp() {
        service1 = new AGMEService("service1", new BigDecimal("10.50"));
    }

    @AfterEach
    void cleanUp() {
        agmeServiceService.deleteService(service1.getServiceName());
    }

    //Author: Matt D
    @Test
    @DisplayName("addService: Successfully adding a service")
    void _1_addService_True_service1() {
        AGMEService addedService = agmeServiceService.addService(service1);
        assertTrue(TestUtilities.sameService(service1, addedService));
    }

    //Author: Matt D
    @Test
    @DisplayName("addService: Service already exists")
    void _2_addService_ThrowsServiceExceptionAndOutputMessage_service1Twice() {
        agmeServiceService.addService(service1);

        Exception exception = assertThrows(ServiceException.class, ()->agmeServiceService.addService(service1));

        String expectedMessage = "service1 is already used";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //Author: Matt D
    @Test
    @DisplayName("findService: Service is successfully found")
    void _1_findService_True_service1() {
        agmeServiceService.addService(service1);
        assertTrue(TestUtilities.sameService(service1, agmeServiceService.findService(service1.getServiceName())));
    }

    //Author: Matt D
    @Test
    @DisplayName("findService: Service is not found")
    void _2_findService_Null_service1() {
        assertNull(agmeServiceService.findService(service1.getServiceName()));
    }
}
