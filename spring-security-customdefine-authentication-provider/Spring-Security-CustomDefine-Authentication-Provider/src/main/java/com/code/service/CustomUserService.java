package com.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.model.User;
import com.code.repository.UserRepository;

@Service
public class CustomUserService /*implements UserDetailsService */{

	/*
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// List<User> user = userRepository.findByEmail(username);
		User user = userRepository.findByEmail(username);

//		if (user.isEmpty()) {
//
//			throw new UsernameNotFoundException("user details not find for the user:" + user);
//		}

		if (user == null)
			throw new UsernameNotFoundException("user details not find");

		return user != null ? new CustomUserDetails(user) : null;

//		return new CustomUserDetails(user.get(0));
	}
	*/

}
