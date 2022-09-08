package com.shopme.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Country;
import com.shopme.setting.CountryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository repo;

	@Test
	public void testFindByCode() {

		String code = "IN";
		Country country = repo.findByCode(code);
		System.out.print(country.getName() + " " + country.getCode());
	}

}
