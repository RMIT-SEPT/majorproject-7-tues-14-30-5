package com.rmit.sept.agme.bookingappbackend.testUtilities;

import com.rmit.sept.agme.bookingappbackend.model.User;

public class TestUtilities {

    /**
     * Helper function for test classes - Checks if two users have the same details
     * @param a First User
     * @param b Second User
     * @return True if they have the exact same data in their fields
     */
    public static boolean sameUser(User a, User b) {
        if (a.getUsername().equals(b.getUsername()) && a.getPassword().equals(b.getPassword()) &&
                a.getName().equals(b.getName()) && a.getAddress().equals(b.getAddress()) &&
                a.getContactNo().equals(b.getContactNo()) && a.getRole().equals(b.getRole())) {
            return true;
        } else {
            return false;
        }
    }
}
