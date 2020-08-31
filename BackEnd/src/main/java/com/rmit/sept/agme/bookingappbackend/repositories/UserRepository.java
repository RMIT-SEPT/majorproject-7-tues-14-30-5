package com.rmit.sept.agme.bookingappbackend.repositories;

import com.rmit.sept.agme.bookingappbackend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

//    @Override
//    Iterable<User> findAllById(Iterable<String> iterable);
//
//    @Query("SELECT COUNT(u) FROM User u")
//    int countUsers();

}
