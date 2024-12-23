package com.kravchenko.booking.dao;

import com.kravchenko.booking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long> {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);

}
