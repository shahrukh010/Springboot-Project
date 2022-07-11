package com.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.code.entity.User;
import com.code.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtAuthenticationApplication {
	
	
	@Autowired
	private UserRepository repository;
	@PostConstruct
	public void init() {
		System.out.println("init..........");
		
		List<User> users = Stream.of(
				new User(1111,"annie","hector","annie@gmail.com"),
				new User(2222,"bridget","nic","bridget@gmail.com"),
				new User(3333,"hector","annie","annie@gmail.com"),
				new User(4444,"nic","bridget","nic@gmail.com")
				).collect(Collectors.toList());
		
		repository.saveAll(users);
		System.out.println(users.get(0).getUser());
		System.out.println(repository.findByUser("javatechie"));
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtAuthenticationApplication.class, args);
	}

}
