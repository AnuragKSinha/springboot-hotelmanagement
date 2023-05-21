package io.anuragksinha.hotel.service.hotel.service.services;

import java.util.List;

import io.anuragksinha.hotel.service.hotel.service.entities.Hotel;

public interface HotelService {
	public Hotel create(Hotel hotel);
	public List<Hotel> getAllHotels();
	public Hotel getHotelById(String id);
	public void deleteHotelById(String id);
}
