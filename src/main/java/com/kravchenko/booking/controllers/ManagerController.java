package com.kravchenko.booking.controllers;

import com.kravchenko.booking.entities.Room;
import com.kravchenko.booking.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final RoomService roomService;

    @GetMapping
    public String getManagerPanel(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "15") int size,
                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                  @RequestParam(name = "direction", defaultValue = "asc") String sortDirection,
                                  Model model) {
        Page<Room> roomsByStatus = roomService.getRoomsByStatus(Room.Status.PROCESS, page, size, sortBy, sortDirection);
        model.addAttribute("page", roomsByStatus);
        model.addAttribute("rooms", roomsByStatus.getContent());
        return "manager-panel";
    }

}
