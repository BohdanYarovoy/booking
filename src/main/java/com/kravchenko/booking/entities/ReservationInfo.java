package com.kravchenko.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReservationInfo {
    private Long roomId;
    private User user;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int guestNumber;
    private double totalPrice;

    public boolean isValidDates() {
        if (this.checkIn == null || this.checkOut == null)
            return false;
        if (!checkOut.isAfter(checkIn)) {
            return false;
        }

        return checkIn.isAfter(LocalDate.now().minusDays(1));
    }
}
