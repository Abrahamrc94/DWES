package com.jacaranda.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jacaranda.security.model.User;
import com.jacaranda.security.model.dto.UserDTO;
import com.jacaranda.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	private ResponseEntity<User> createNewUser(@RequestBody UserDTO user) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(user));
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
