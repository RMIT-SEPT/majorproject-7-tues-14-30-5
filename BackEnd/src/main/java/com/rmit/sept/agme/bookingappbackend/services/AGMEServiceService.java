package com.rmit.sept.agme.bookingappbackend.services;

import com.rmit.sept.agme.bookingappbackend.exceptions.ServiceException;
import com.rmit.sept.agme.bookingappbackend.model.AGMEService;
import com.rmit.sept.agme.bookingappbackend.repositories.AGMEServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Brilliantly-named
 */

@Service
public class AGMEServiceService {
    @Autowired
    private AGMEServiceRepository agmeServiceRepository;

    /**
     * Attempts to add a new user to UserRepository.
     * @param service The service to add to AGMEServiceRepository.
     * @return The same user if it succeeds in adding - Otherwise throw a ServiceException.
     */
//    public AGMEService addService(AGMEService service) {
//        if (agmeServiceRepository.existsById(service.getServiceName())) {
//            throw new ServiceException(service.getServiceName() + " is already used");
//        }
//    }

    /**
     * Attempts to find a certain user in UserRepository.
     * @param serviceName The primary key to search ServiceRepository with.
     * @return Service that matches the service name - Otherwise NULL.
     */
    public AGMEService findService(String serviceName) {
        Optional<AGMEService> serviceOpt = agmeServiceRepository.findById(serviceName);
        if (serviceOpt.isPresent()) {
            return  serviceOpt.get();
        } else {
            return null;
        }
    }
}
