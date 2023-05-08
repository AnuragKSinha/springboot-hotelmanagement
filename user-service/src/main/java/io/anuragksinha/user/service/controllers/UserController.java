package io.anuragksinha.user.service.controllers;

import java.util.List;

import io.anuragksinha.user.service.entities.User;
import io.anuragksinha.user.service.services.UserService;

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
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userNew = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> userById(@PathVariable("userId") String userId){
		User userNew = userService.getUser(userId);
		return ResponseEntity.ok(userNew);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userNews = userService.getAllUsers();
		return ResponseEntity.ok(userNews);
	}

}
