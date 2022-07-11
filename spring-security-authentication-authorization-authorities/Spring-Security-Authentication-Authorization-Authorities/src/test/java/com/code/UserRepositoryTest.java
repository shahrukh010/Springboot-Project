package com.code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.code.model.Customer;
import com.code.repository.UserRepository;

@SpringBootTest
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	
	public void listAll() {
		
	java.util.List<Customer>user = userRepo.findAll();
		
	}

}
