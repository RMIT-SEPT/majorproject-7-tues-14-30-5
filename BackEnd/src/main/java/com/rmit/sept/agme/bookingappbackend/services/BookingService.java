package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.exceptions.BookingException;
import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import com.rmit.sept.agme.bookingappbackend.model.Booking;
import com.rmit.sept.agme.bookingappbackend.model.User;
import com.rmit.sept.agme.bookingappbackend.repositories.BookingRepository;
import com.rmit.sept.agme.bookingappbackend.requests.CreateBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AGMEServiceService agmeServiceService;

    public Booking addBooking(CreateBookingRequest request) {
        if (request.getDateTime().after(new Date())) {
            User customer = userService.findUser(request.getCustomer());
            User worker = userService.findUser(request.getWorker());
            AGMEService service = agmeServiceService.findService(request.getService());
            Booking booking = new Booking(request.getDateTime(), worker, customer, service, service.getPrice());
            return bookingRepository.save(booking);
        } else {
            throw new BookingException("Cannot book before today");
        }

    }
}
