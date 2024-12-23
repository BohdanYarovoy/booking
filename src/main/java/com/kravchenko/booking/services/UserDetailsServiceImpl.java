package com.kravchenko.booking.services;

import com.kravchenko.booking.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.kravchenko.booking.utils.Validator.isItEmail;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        boolean isEmail = isItEmail(login);

        user = isEmail ? userService.getByEmail(login) : userService.getByUsername(login);

        return org.springframework.security.core.userdetails.User.builder()
                .username(isEmail ? user.getEmail() : user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }
}
