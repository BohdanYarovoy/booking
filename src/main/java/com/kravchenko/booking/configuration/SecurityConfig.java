package com.kravchenko.booking.configuration;

import com.kravchenko.booking.entities.User;
import com.kravchenko.booking.services.UserDetailsServiceImpl;
import com.kravchenko.booking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsServiceImpl userDetailsServiceImpl) throws Exception {
        httpSecurity
                .userDetailsService(userDetailsService)
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(
                                "/",
                                "/login",
                                "/registration",
                                "/img/**",
                                "/styles/**"
                        ).permitAll()
                        .requestMatchers("/manager/**").hasRole(User.Role.MANAGER.toString())
                        .anyRequest().authenticated()
                )
                .formLogin(form -> {
                    form.loginPage("/login");
                    form.permitAll();
                })
                .logout(e -> {
                    e.permitAll();
                    e.logoutUrl("/logout");
                    e.logoutSuccessUrl("/");
                });

        return httpSecurity.build();
    }

}
