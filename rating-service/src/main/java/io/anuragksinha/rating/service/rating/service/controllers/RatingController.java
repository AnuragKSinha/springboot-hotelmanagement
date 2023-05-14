package io.anuragksinha.rating.service.rating.service.controllers;

import java.util.List;

import io.anuragksinha.rating.service.rating.service.entities.Rating;
import io.anuragksinha.rating.service.rating.service.services.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService service;
    @PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return new ResponseEntity<>(service.createRating(rating), HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		return ResponseEntity.ok(service.getAllRatings());
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(service.getRatingById(userId));
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
	}

}

