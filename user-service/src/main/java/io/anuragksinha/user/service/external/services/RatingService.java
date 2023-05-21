package io.anuragksinha.user.service.external.services;

import java.util.List;

import io.anuragksinha.user.service.entities.Rating;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRatings(@PathVariable String userId);
}
