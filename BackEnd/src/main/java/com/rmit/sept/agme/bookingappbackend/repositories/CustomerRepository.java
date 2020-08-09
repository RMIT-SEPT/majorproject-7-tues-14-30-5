package com.rmit.sept.agme.bookingappbackend.repositories;

import com.rmit.sept.agme.bookingappbackend.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Override
    Iterable<Customer> findAllById(Iterable<String> iterable);
}
