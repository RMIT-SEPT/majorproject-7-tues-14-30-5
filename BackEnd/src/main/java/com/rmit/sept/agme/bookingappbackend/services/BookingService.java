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
        Date current = new Date();
        if (request.getDateTime().after(current)) {
            User worker = userService.findUser(request.getWorker());
            AGMEService service = agmeServiceService.findService(request.getService());
            User customer = userService.findUser(request.getCustomer());
            if (worker.equals(null)) {
                throw new BookingException("Worker not found");
            } else if (service.equals(null)) {
                throw new BookingException("Service not found");
            } else if (customer.equals(null)) {
                throw new BookingException("Customer account has been deleted");
            } else {
                Booking booking = new Booking(request.getDateTime(), worker, customer, service, service.getPrice());
                System.out.println("BOOKING ID IS: " + booking.getBookingId());
                return bookingRepository.save(booking);
            }
        } else {
            throw new BookingException("Cannot book before today");
        }
    }

    /**
     * HELPER: Used for cleanup in BookingServiceTests
     * @param bookingID The booking ID to find and delete
     */
    public void deleteBooking(long bookingID) {
        if (bookingRepository.existsById(bookingID)) {
            bookingRepository.deleteById(bookingID);
        }
    }
}
