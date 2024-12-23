package com.kravchenko.booking.services;

import com.kravchenko.booking.dao.UserRepositoryJPA;
import com.kravchenko.booking.entities.User;
import com.kravchenko.booking.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepositoryJPA userRepository;

    @Override
    public User getById(Long id) {
        if (id == null) {
            throw new NullPointerException("UserId is required");
        }

        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id:%s not exists".formatted(id)));
    }

    @Override
    public User getByLogin(String login) {
        if (login == null)
            throw new NullPointerException("Login is null");

        if (Validator.isItEmail(login)) {
            return getByEmail(login);
        } else {
            return getByUsername(login);
        }
    }

    @Override
    public User createUser(User user) {
        if (user == null) {
            throw new NullPointerException("Parameter user is null.");
        }
        user.setId(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User changeUser(User user) {
        if (user.getId() == null) {
            throw new NullPointerException("UserId is required");
        }

        if (userRepository.existsById(user.getId())) {
            changeUserPassword(user);
            return userRepository.save(user);
        } else {
            throw new NoSuchElementException("User with id:%s not exists".formatted(user.getId()));
        }
    }

    private void changeUserPassword(User user) {
        User dbUser = getById(user.getId());

        if (!dbUser.getPassword().equals(user.getPassword())) {
            String newPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(newPassword);
        }
    }

    @Override
    public void removeById(Long id) {
        if (id == null) {
            throw new NullPointerException("UserId is required");
        }

        userRepository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Email is required");
        }

        return userRepository.getUserByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User with email:%s not found".formatted(email)));
    }

    @Override
    public User getByUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username is required");
        }

        return userRepository.getUserByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("User with username:%s not found".formatted(username)));
    }
}
