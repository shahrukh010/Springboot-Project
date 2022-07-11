package com.code.main.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.code.main.model.User;

public interface UserRepository extends ElasticsearchRepository<User, Integer> {

	public List<User> findByFirstName(String firstName);

}
