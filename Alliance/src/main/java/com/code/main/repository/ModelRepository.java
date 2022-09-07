package com.code.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.main.model.Make;
import com.code.main.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

	public List<Model> findByMake(Make make);
}
