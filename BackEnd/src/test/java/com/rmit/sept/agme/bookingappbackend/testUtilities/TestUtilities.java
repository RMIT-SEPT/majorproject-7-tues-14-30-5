package com.rmit.sept.agme.bookingappbackend.testUtilities;

import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import com.rmit.sept.agme.bookingappbackend.model.User;

public class TestUtilities {

    /**
     * Helper function for test classes - Checks if two users have the same details
     * @param expected First User
     * @param actual Second User
     * @return True if they have the exact same data in their fields
     */
    public static boolean sameUser(User expected, User actual) {
        return expected.getUsername().equals(actual.getUsername()) && expected.getPassword().equals(actual.getPassword()) &&
                expected.getName().equals(actual.getName()) && expected.getAddress().equals(actual.getAddress()) &&
                expected.getContactNo().equals(actual.getContactNo()) && expected.getRole().equals(actual.getRole());
    }

    /**
     * Helper function for test classes - Checks if two services have the same details
     * @param expected First service
     * @param actual Second service
     * @return True if they have the exact same data in their fields
     */
    public static boolean sameService(AGMEService expected, AGMEService actual) {
        return expected.getServiceName().equals(actual.getServiceName()) && expected.getPrice().equals(actual.getPrice());
    }
}
