package com.kravchenko.booking.dao;

import com.kravchenko.booking.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepositoryJPA extends JpaRepository<Room, Long> {
    Page<Room> findAll(Pageable pageable);
    Page<Room> findByStatus(Room.Status status, Pageable pageable);
}
