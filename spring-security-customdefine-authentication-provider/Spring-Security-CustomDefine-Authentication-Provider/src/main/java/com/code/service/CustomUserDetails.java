package com.code.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.code.model.User;

//override user UserDetails implementation
//like how to fetch user details  from database,ldap,
public class CustomUserDetails/* implements UserDetails*/ {

	/*
	private User user;

	public CustomUserDetails(User user) {

		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

//		List<GrantedAuthority> authority = new ArrayList<>();
//		authority.add(new SimpleGrantedAuthority(user.getRole()));
//		return authority;

	}

	@Override
	public String getPassword() {
		return user.getPasswd();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	*/

}
