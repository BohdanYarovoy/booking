package com.kravchenko.booking.controllers;

import com.kravchenko.booking.entities.ReservationInfo;
import com.kravchenko.booking.entities.Room;
import com.kravchenko.booking.entities.User;
import com.kravchenko.booking.services.RoomService;
import com.kravchenko.booking.services.UserService;
import com.kravchenko.booking.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.kravchenko.booking.utils.Utils.calculateRoomNumber;

@RequiredArgsConstructor
@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final UserService userService;

    @GetMapping
    public String getRoomsList(@RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "15") int size,
                               @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                               @RequestParam(name = "direction", defaultValue = "ask") String direction,
                               Model model) {
        Page<Room> rooms = roomService.getRooms(page, size, sortBy, direction);
        model.addAttribute("rooms", rooms.getContent());
        model.addAttribute("page", rooms);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);
        return "room-list";
    }

    @GetMapping("/{roomId}")
    public String getRoomInfo(@PathVariable(name = "roomId") Long id,
                              Model model) {
        Room room = roomService.getById(id);
        model.addAttribute("room", room);
        model.addAttribute("roomNumber", calculateRoomNumber(room));
        model.addAttribute("checkOut", room.getFormattedCheckOut());

        return "room-details";
    }

    @PostMapping("/takeRoom")
    public String makeReservation(@RequestParam(name = "checkIn") LocalDate checkInDate,
                                  @RequestParam(name = "checkOut") LocalDate checkOutDate,
                                  @RequestParam(name = "roomId") Long roomId,
                                  @RequestParam(name = "guestsCount") int guestCount,
                                  @RequestParam(name = "totalPrice") int totalPrice,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.getByLogin(userDetails.getUsername());
        ReservationInfo reservationInfo = new ReservationInfo(roomId, user, checkInDate, checkOutDate, guestCount, totalPrice);

        if (reservationInfo.isValidDates()) {
            user = roomService.makeRequestForBook(reservationInfo);
            userService.changeUser(user);
            return "redirect:/user";
        }
        return "redirect:/rooms/%d".formatted(roomId);
    }

    @PostMapping("/rejectReservation")
    public String rejectReservation(@RequestParam(name = "userId") Long userId,
                                    @RequestParam(name = "roomId") Long roomId) {
        User user = userService.getById(userId);
        roomService.cancelReservation(user, roomId);

        return "redirect:/manager";
    }

    @PostMapping("/cancelReservation")
    public String cancelReservation(@RequestParam(name = "userId") Long userId,
                                    @RequestParam(name = "roomId") Long roomId) {
        User user = userService.getById(userId);
        roomService.cancelReservation(user, roomId);

        return "redirect:/user";
    }

    @PostMapping("/applyReservation")
    public String applyReservation(@RequestParam(name = "roomId") Long roomId) {
        roomService.applyReservation(roomId);
        return "redirect:/manager";
    }

    @PostMapping("/payForRoom")
    public String payForRoom(@RequestParam(name = "roomId") Long roomId) {
        roomService.payForRoom(roomId);
        return "redirect:/user";
    }

}
