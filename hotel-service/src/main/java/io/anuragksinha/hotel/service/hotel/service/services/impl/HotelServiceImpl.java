package io.anuragksinha.hotel.service.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import io.anuragksinha.hotel.service.hotel.service.entities.Hotel;
import io.anuragksinha.hotel.service.hotel.service.exceptions.ResourceNotFoundException;
import io.anuragksinha.hotel.service.hotel.service.repositories.HotelRepository;
import io.anuragksinha.hotel.service.hotel.service.services.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel create(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("hotel with given id is not found"));
	}

	@Override
	public void deleteHotelById(String id) {
		 hotelRepository.deleteById(id);
	}
}
