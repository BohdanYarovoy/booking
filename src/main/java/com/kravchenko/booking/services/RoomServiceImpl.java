package com.kravchenko.booking.services;

import com.kravchenko.booking.dao.RoomRepositoryJPA;
import com.kravchenko.booking.entities.ReservationInfo;
import com.kravchenko.booking.entities.Room;
import com.kravchenko.booking.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepositoryJPA roomRepository;

    @Override
    public Page<Room> getRooms(int page, int size, String sortBy, String sortDirection) {
        PageRequest pageable = getPageable(page, size, sortBy, sortDirection);
        return roomRepository.findAll(pageable);
    }

    @Override
    public Page<Room> getRoomsByStatus(Room.Status status, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageable = getPageable(page, size, sortBy, sortDirection);
        return roomRepository.findByStatus(status, pageable);
    }

    private PageRequest getPageable(int page, int size, String sortBy, String sortDirection) {
        Sort sort = createSort(sortBy, sortDirection);
        return PageRequest.of(page, size, sort);
    }

    private Sort createSort(String sortBy, String sortDirection) {
        return sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
    }

    @Override
    public Room getById(Long id) {
        if (id == null)
            throw new NullPointerException("Parameter id is null");

        Optional<Room> room = roomRepository.findById(id);
        return room.orElseThrow(() -> new NoSuchElementException("Room with id:%s not found".formatted(id)));
    }

    @Override
    public Room createRoom(Room room) {
        if (room == null)
            throw new NullPointerException("Parameter room is null");

        room.setId(null);
        return roomRepository.save(room);
    }

    @Override
    public Room changeRoom(Room room) {
        if (room == null)
            throw new NullPointerException("Parameter room is null");

        if (room.getId() == null)
            throw new IllegalArgumentException("Room id is required");

        return roomRepository.save(room);
    }

    @Override
    public void removeById(Long id) {
        if (id == null)
            throw new NullPointerException("Parameter id is null");

        roomRepository.deleteById(id);
    }

    @Override
    public User makeRequestForBook(ReservationInfo reservationInfo) {
        if (reservationInfo == null)
            throw new NullPointerException("Parameter is null");

        Room room = getById(reservationInfo.getRoomId());
        room.setStatus(Room.Status.PROCESS);
        room.setCurrentGuestCount(reservationInfo.getGuestNumber());
        room.setBookedFrom(Timestamp.valueOf(reservationInfo.getCheckIn().atStartOfDay()));
        room.setBookedTo(Timestamp.valueOf(reservationInfo.getCheckOut().atStartOfDay()));
        room.setTotalPrice(reservationInfo.getTotalPrice());

        User user = reservationInfo.getUser();
        if (user.getRoom() != null) {
            cancelReservation(user, user.getRoom().getId());
        }
        user.setRoom(room);
        return user;
    }

    @Override
    public void cancelReservation(User user, Long roomId) {
        user.setRoom(null);
        Room room = getById(roomId);
        room.setUser(null);
        room.setStatus(Room.Status.FREE);
        room.setCurrentGuestCount(0);
        room.setBookedFrom(null);
        room.setBookedTo(null);
        room.setTotalPrice(0);
        room.setTimeForPay(null);
        changeRoom(room);
    }

    @Override
    public void applyReservation(Long roomId) {
        Room room = getById(roomId);
        room.setTimeForPay(Timestamp.valueOf(LocalDateTime.now().plusDays(2)));
        room.setStatus(Room.Status.FORPAY);
        changeRoom(room);
    }

    @Override
    public void payForRoom(Long roomId) {
        Room room = getById(roomId);
        room.setStatus(Room.Status.BOOKED);
        room.setTimeForPay(null);
        changeRoom(room);
    }

}
