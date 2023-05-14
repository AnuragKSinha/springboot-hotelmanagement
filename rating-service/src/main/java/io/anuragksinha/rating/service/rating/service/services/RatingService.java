package io.anuragksinha.rating.service.rating.service.services;

import java.util.List;

import io.anuragksinha.rating.service.rating.service.entities.Rating;

public interface RatingService {
	public Rating createRating(Rating rating);
	public List<Rating> getAllRatings();
	public List<Rating> getRatingById(String userId);
	public List<Rating> getRatingByHotelId(String hotelId);
}
