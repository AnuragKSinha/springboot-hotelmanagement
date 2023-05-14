package io.anuragksinha.rating.service.rating.service.repository;

import java.util.List;

import io.anuragksinha.rating.service.rating.service.entities.Rating;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating,String> {
	//Custom finder methods
	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);
}
