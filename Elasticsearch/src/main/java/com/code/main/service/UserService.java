package com.code.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.main.model.User;
import com.code.main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User newUserSave(User user) {

		return userRepo.save(user);

	}

	public Iterable<User> getAll() {

		return userRepo.findAll();
	}

	public List<User> getByName(String firstName) {

		return (List<User>) userRepo.findByFirstName(firstName);
	}
}
