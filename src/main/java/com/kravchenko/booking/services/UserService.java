package com.kravchenko.booking.services;

import com.kravchenko.booking.entities.User;

import java.util.Optional;

public interface UserService {
    User getById(Long id);
    User getByLogin(String login);
    User createUser(User user);
    User changeUser(User user);
    void removeById(Long id);
    User getByEmail(String login);
    User getByUsername(String login);
}
