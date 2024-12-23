package com.kravchenko.booking.controllers;

import com.kravchenko.booking.entities.User;
import com.kravchenko.booking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUserCabinet(@AuthenticationPrincipal UserDetails userDetails,
                                 Model model) {
        User user = userService.getByLogin(userDetails.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("reservedRoom", user.getRoom());
        return "user-cabinet";
    }

}
