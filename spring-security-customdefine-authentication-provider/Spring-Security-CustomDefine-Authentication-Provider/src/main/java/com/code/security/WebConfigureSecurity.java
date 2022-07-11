package com.code.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfigureSecurity extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		/*
//		 * without security access all form to any request/users
//		 */
//		http.authorizeHttpRequests()
//		.anyRequest().authenticated()
//		.and().formLogin()//form like contact,login,registration
//		.and().httpBasic();
//	}

//******************************************************************************

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//some form authenticated required or some not 
		http.authorizeHttpRequests()
		.antMatchers("/account").authenticated()
		.antMatchers("/balance").authenticated()
		.antMatchers("/loan").authenticated()
		.antMatchers("/card").authenticated()
		.antMatchers("/contact").permitAll()
		.antMatchers("/notice").permitAll()
		.and().httpBasic();
	}

//	@Override
//	public void configure(HttpSecurity http)throws Exception {
//		
//		
//		//deny accessability 
//		http.authorizeHttpRequests()
//		.anyRequest().denyAll()
//		.and().formLogin().and().httpBasic();
//	}	

//	@Override
//	public void configure(HttpSecurity http)throws Exception {
//		
//		//not required any kind of security
//		http.authorizeHttpRequests()
//		.anyRequest().permitAll()
//		.and().formLogin().and().httpBasic();
//		
//	}
//
//	

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	// if override this method then for creditial application.properties creditial
	// not required
	/*
	 * this method where allowed to customize user,userd etail,passencoder,role
	 * 
	 * AuthenticationManagerBuilder it is class allows for easily binding in memory
	 * authentication,ldap,jdbc based authentication adding UserDetailService and
	 * AuthenticationProvider
	 */
	// Ok Fine let me show to you in-memory authentication

//		auth.inMemoryAuthentication().withUser("annie").password("hector")
//		.authorities("dev")
//		.and().withUser("hector").password("annie")
//		.authorities("dev")
//		.and().withUser("bridget")
//		.password("nic").authorities("admin")
//		.and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//	}

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		InMemoryUserDetailsManager userDetailManager = new InMemoryUserDetailsManager();
//
//		UserDetails user1 = User.withUsername("annie").password("hector").authorities("dev").build();
//		UserDetails user2 = User.withUsername("bridget").password("nic").authorities("dev").build();
//		
//		userDetailManager.createUser(user1);
//		userDetailManager.createUser(user2);
//		auth.userDetailsService(userDetailManager);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {

//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {

	/**
	 * if you use JdbcUserDetailsManager then tables and column must be same like
	 * JdbcUserDetailsManager defined
	 */
//		return new JdbcUserDetailsManager(dataSource);
//		
//	}

}
