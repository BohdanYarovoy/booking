package com.kravchenko.booking.services;

import com.kravchenko.booking.entities.ReservationInfo;
import com.kravchenko.booking.entities.Room;
import com.kravchenko.booking.entities.User;
import org.springframework.data.domain.Page;

public interface RoomService {
    Page<Room> getRooms(int page, int size, String sortBy, String sortDirection);
    Page<Room> getRoomsByStatus(Room.Status status, int page, int size, String sortBy, String sortDirection);
    Room getById(Long id);
    Room createRoom(Room room);
    Room changeRoom(Room room);
    void removeById(Long id);

    User makeRequestForBook(ReservationInfo reservationInfo);
    void cancelReservation(User user, Long roomId);
    void applyReservation(Long roomId);
    void payForRoom(Long roomId);
}
