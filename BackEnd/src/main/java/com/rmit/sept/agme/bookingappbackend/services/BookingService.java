package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.model.Booking;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.BookingRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepositry bookingRepositry;
    @Autowired
    private UserService userService;

    public Booking saveOrUpdateBooking(Booking booking, String ) {

//        User worker = userService.findUser()

        return bookingRepositry.save(booking);
    }

}
