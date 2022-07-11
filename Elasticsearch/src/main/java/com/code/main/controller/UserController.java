package com.code.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.main.model.User;
import com.code.main.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/users/save")
	public ResponseEntity<User> newUser(@RequestBody User user) {

		return new ResponseEntity<>(service.newUserSave(user), HttpStatus.CREATED);
	}

	@GetMapping("/users/get")
	public Iterable<User> getAllUsers() {

		return service.getAll();
	}

	@GetMapping("/users/findByName/{firstName}")
	public List<User> getByName(@PathVariable String firstName) {

		return service.getByName(firstName);
	}
}
