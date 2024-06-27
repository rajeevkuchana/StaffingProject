package com.staffing.jobportal.controller;

import java.util.List;

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

import com.staffing.jobportal.models.User;
import com.staffing.jobportal.service.UserService;

@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
	}

	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/verify/{username}")
	public ResponseEntity<User> verifyUser(@PathVariable String username) {
		User user = userService.verifyUser(username);

		return ResponseEntity.status(HttpStatus.OK).body(user);

	}

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = userService.getAllUsers();

		return ResponseEntity.status(HttpStatus.OK).body(userList);

	}

}
