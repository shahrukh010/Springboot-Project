package com.code.main.model.year;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.code.main.model.Make;
import com.code.main.model.Year;
import com.code.main.repository.MakeRepository;
import com.code.main.repository.YearRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class YearRepositoryTest {

	@Autowired
	private YearRepository repository;
	@Autowired
	private MakeRepository repo;
	@Autowired
	private EntityManager entityManager;

	@Test
	public void createYear() {

		Year year = new Year("2050");
		repository.save(year);
	}

	@Test
	public void listAllYear() {

		List<Year> listYear = repository.findAll();
		listYear.forEach(name -> System.out.println(name.getYear()));

	}

	public void getMake() {

	}

}
