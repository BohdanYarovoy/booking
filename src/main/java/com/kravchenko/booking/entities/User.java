package com.kravchenko.booking.entities;

import com.kravchenko.booking.utils.Validator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "B_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 4, max = 32, message = "Username must be between 4 and 32 characters.")
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotBlank(message = "First name cannot be blank.")
    @Size(min = 2, max = 255, message = "First name must be between 2 and 255 characters.")
    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotBlank(message = "Last name cannot be blank.")
    @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters.")
    @Column(name = "LASTNAME")
    private String lastname;

    @NotBlank(message = "Phone cannot be blank.")
    @Size(min = 6, max = 32, message = "Phone must be between 6 and 32 characters.")
    @Column(name = "PHONE")
    private String phone;

    @Email(regexp = Validator.EMAIL_PATTERN, message = "Email must be a valid format.")
    @NotEmpty(message = "Email cannot be empty.")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
    @Column(name = "PASSWORD")
    private String password;

    @NotNull(message = "Role cannot be null.")
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    public enum Role {
        USER,
        MANAGER,
    }

}
