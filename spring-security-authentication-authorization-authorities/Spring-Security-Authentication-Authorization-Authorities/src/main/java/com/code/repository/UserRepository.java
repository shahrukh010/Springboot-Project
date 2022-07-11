package com.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.model.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByEmail(String email);
//	User findByEmail(String input);
}
