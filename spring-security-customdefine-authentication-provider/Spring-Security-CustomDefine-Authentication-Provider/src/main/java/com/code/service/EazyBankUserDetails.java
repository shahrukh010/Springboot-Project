package com.code.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.code.model.User;
import com.code.repository.UserRepository;

@Component
public class EazyBankUserDetails implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// getName() method present inside Principle interface
		String username = authentication.getName();// from client side/web
		// getCredentials()present Authentication interface extending Principle
		String passwd = authentication.getCredentials().toString();

		User user = userRepository.findByEmail(username);

		if (user != null) {
			// matches call method goes call into our spring securityconfig class and lock
			// passwordEncoder which way there define
			if (passwordEncoder.matches(passwd, user.getPasswd())) {

				Collection c = java.util.Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

				// authenticate by username and password more way also we can do
				// 1:Username and password
				// 2:Finger Print
				// 3:Face Scan
				return new UsernamePasswordAuthenticationToken(username, passwd, c);
			} else {
				// throw BadCredentialsException to client side
				throw new BadCredentialsException("invalid password");
			}

		} else {
			throw new BadCredentialsException("invalid user");
		}

	}

	@Override // defining which way authentication doing
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
