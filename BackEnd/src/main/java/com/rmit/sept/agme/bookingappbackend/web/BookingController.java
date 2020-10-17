package com.rmit.sept.agme.bookingappbackend.web;

import com.rmit.sept.agme.bookingappbackend.exceptions.BookingException;
import com.rmit.sept.agme.bookingappbackend.model.Booking;
import com.rmit.sept.agme.bookingappbackend.requests.CreateBookingRequest;
import com.rmit.sept.agme.bookingappbackend.requests.GetBookingsByUserRequest;
import com.rmit.sept.agme.bookingappbackend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewBooking(@Valid @RequestBody CreateBookingRequest createBookingRequest, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        try {
            Booking newBooking = bookingService.addBooking(createBookingRequest);
            return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
        } catch (BookingException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<?> getAllBookingsByUser(@Valid @RequestBody GetBookingsByUserRequest request, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        try {
            List<Booking> bookingList = bookingService.displayUserBooking(request);
            return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
        } catch  (BookingException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
