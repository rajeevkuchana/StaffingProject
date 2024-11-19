package com.staffing.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.staffing.jobportal.models.User;
import com.staffing.jobportal.models.UserLogin;
import com.staffing.jobportal.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "http://localhost:3000", "http://3.81.66.16:3000", "https://portal.quantlytixsolutions.com" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/")
@Api(tags = "User Management", description = "Endpoints for managing user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String createStatus = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(createStatus);
	}

	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String userId) {
		boolean deleteStatus = userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(deleteStatus);
	}

	@PostMapping("/user/verify")
	public ResponseEntity<User> verifyUser(
			@ApiParam(value = "Profile object to be added", required = true) @RequestBody UserLogin userLogin) {
		User user = userService.verifyUser(userLogin.getEmail());
		if(null != user) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
		}
	}

	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}

}
