package com.demo.aparna.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.aparna.project.model.User;
import com.demo.aparna.project.service.UserService;

@RestController
@RequestMapping("/register")
@CrossOrigin("http://localhost:4200")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createUser = userService.createUser(user);
		return new ResponseEntity<User>(createUser, HttpStatus.OK);

	}

	@GetMapping("/displayuser")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUser();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long id) {
		User editUser = userService.updateUser(user);
		return new ResponseEntity<User>(editUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully", HttpStatus.OK);
	}
}
