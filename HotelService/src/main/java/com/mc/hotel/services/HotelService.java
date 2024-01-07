package com.mc.hotel.services;

import com.mc.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotel(String id);
}
