package com.kravchenko.booking.utils;

import com.kravchenko.booking.entities.Room;

public class Utils {

    public static int calculateRoomNumber(Room room) {
        return room.getNumber() + room.getHotelFloor() * 100;
    }

}
