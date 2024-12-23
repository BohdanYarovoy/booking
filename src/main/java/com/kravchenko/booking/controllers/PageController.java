package com.kravchenko.booking.controllers;

import com.kravchenko.booking.entities.User;
import com.kravchenko.booking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PageController {
    private final UserService userService;

    @GetMapping
    public ModelAndView getIndexPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationForm", User.builder().build());

        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute(value = "registrationForm") User createdUser) {
        createdUser.setRole(User.Role.USER);
        userService.createUser(createdUser);
        return "redirect:/login";
    }

}
