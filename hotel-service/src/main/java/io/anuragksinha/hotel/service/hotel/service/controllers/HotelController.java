package io.anuragksinha.hotel.service.hotel.service.controllers;

import java.util.List;

import io.anuragksinha.hotel.service.hotel.service.entities.Hotel;
import io.anuragksinha.hotel.service.hotel.service.services.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getById(@PathVariable String id){
		return ResponseEntity.ok(hotelService.getHotelById(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable String id){
		hotelService.deleteHotelById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
