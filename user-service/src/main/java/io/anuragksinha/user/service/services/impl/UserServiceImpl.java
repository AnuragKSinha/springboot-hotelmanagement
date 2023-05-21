package io.anuragksinha.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.anuragksinha.user.service.entities.Hotel;
import io.anuragksinha.user.service.entities.Rating;
import io.anuragksinha.user.service.entities.User;
import io.anuragksinha.user.service.exceptions.ResourceNotFoundException;
import io.anuragksinha.user.service.external.services.HotelService;
import io.anuragksinha.user.service.external.services.RatingService;
import io.anuragksinha.user.service.repositories.UserRepository;
import io.anuragksinha.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		//generate unique userId
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->
				new ResourceNotFoundException("User with given id is not found on server!!"+userId));
		//Rating[] ratingsArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		List<Rating> ratingList= ratingService.getRatings(userId);
		logger.info(ratingList.toString());
		ratingList=ratingList.stream().map(rating -> {
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			//Hotel hotel=restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public Boolean delete(String userId) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}
}
