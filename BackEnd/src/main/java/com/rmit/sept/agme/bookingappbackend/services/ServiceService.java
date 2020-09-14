package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.rmit.sept.agme.bookingappbackend.model.Service;

import java.util.Optional;

/**
 * Brilliantly-named
 */

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    /**
     * Attempts to find a certain user in UserRepository.
     * @param serviceName The primary key to search ServiceRepository with.
     * @return Service that matches the service name - Otherwise NULL.
     */
    public Service findService(String serviceName) {
        Optional<Service> serviceOpt = serviceRepository.findById(serviceName);
        if (serviceOpt.isPresent()) {
            return  serviceOpt.get();
        } else {
            return null;
        }
    }
}
