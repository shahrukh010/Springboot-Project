package com.code.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.main.model.Make;
import com.code.main.model.Year;

public interface YearRepository extends JpaRepository<Year, Integer> {

}
