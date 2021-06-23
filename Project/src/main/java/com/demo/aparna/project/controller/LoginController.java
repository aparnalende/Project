package com.demo.aparna.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.aparna.project.model.User;
import com.demo.aparna.project.repository.UserRepository;
import com.demo.aparna.project.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		User user = userService.getUser(username);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		String tempusername = user.getusername();
		User userObj = null;
		if (tempusername != null) {
			userObj = userRepository.findByUsername(tempusername);
		}
		if (userObj == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userObj, HttpStatus.OK);

	}

}
