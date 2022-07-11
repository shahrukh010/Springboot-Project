package com.code.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.code.service.CustomUserDetailService;
import com.code.util.JwtUtil;

@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;

		// extract token from httpReqstHeader
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {

			// remove Bearer from token
			token = authorizationHeader.substring(7);
			// extract username from token
			username = jwtUtil.extractUsername(token);
		}

		// checking username is not null
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// validate username
			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

			// now validate jwt token

			if (jwtUtil.validateToken(token, userDetails)) {

				// validate UserDetails;
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						username, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				// if userdetails is valid then we have to set securityContext
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
		}
		filterChain.doFilter(request, response);

	}

}
