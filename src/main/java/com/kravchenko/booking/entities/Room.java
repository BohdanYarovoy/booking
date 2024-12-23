package com.kravchenko.booking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "B_ROOM", uniqueConstraints = @UniqueConstraint(columnNames = {"NUMBER", "FLOOR"}))
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "room")
    private User user;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "HOTEL_FLOOR")
    private int hotelFloor;

    @Column(name = "PRICE")
    private double priceForDay;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "ROOM_CAPACITY")
    private int roomCapacity;

    @Column(name = "CURRENT_GUEST_COUNT")
    private int currentGuestCount;

    @Column(name = "TIME_FOR_PAY")
    private Timestamp timeForPay;

    @Column(name = "BOOKED_FROM")
    private Timestamp bookedFrom;

    @Column(name = "BOOKED_TO")
    private Timestamp bookedTo;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    public enum Status {
        FREE,
        BOOKED,
        PROCESS,
        FORPAY,
        UNAVAILABLE
    }

    public enum Type {
        STANDART,
        SUPERIOR,
        DELUX,
        EXECUTIVE,
        SUITE
    }

    public String getFormattedCheckOut() {
        if (this.bookedTo == null)
            return null;
        return this.bookedTo.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public boolean isItOnAdminConfirming() {
        return timeForPay == null && this.status.equals(Status.PROCESS);
    }

    public boolean isPaid() {
        return timeForPay == null && status.equals(Status.BOOKED);
    }
}
