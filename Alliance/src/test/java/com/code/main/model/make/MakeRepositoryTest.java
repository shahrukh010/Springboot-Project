package com.code.main.model.make;

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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MakeRepositoryTest {

	@Autowired
	private MakeRepository repo;

	@Autowired
	private EntityManager entityManager;

	@Test
	public void createMake() {

		Make make = new Make("Honda");
		repo.save(make);

	}

	@Test
	public void testMakeByYear() {

		Integer yearId = 27;

		Year year = entityManager.find(Year.class, yearId);

		List<Make> makeList = List.of(new Make("Porsche"), new Make("Ferrari"), new Make("Ram"),
				new Make("Volvo\n" + ""), new Make("Jaguar"), new Make("Cadillac"), new Make("GMC"));

		for (Make make : makeList) {

			make.getMakes().add(year);
			repo.save(make);
		}

	}
}
