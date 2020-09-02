package com.rmit.sept.agme.bookingappbackend.repositories;

import com.rmit.sept.agme.bookingappbackend.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepositry extends CrudRepository<Booking, Long> {

}
