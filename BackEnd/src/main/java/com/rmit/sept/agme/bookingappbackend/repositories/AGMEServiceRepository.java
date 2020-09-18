package com.rmit.sept.agme.bookingappbackend.repositories;

import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AGMEServiceRepository extends CrudRepository<AGMEService, String> {
}
