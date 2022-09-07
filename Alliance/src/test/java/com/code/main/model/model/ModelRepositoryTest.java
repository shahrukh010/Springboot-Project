package com.code.main.model.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.code.main.model.Make;
import com.code.main.model.Model;
import com.code.main.repository.ModelRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ModelRepositoryTest {

	@Autowired
	private ModelRepository repo;
	@Autowired
	private EntityManager entityManager;

	@Test
	public void createModel() {

		Integer makeId = 14;
		Make make = entityManager.find(Make.class, makeId);
		List<Model> model = List.of(new Model("COROLLA", make), new Model("COROLLA ALTIS", make),
				new Model("CAMRY", make), new Model("ETIOS", make), new Model("FORTUNER", make),
				new Model("GLANZA", make));
		repo.saveAll(model);

	}

	@Test
	public void testModelByMake() {

		Integer makeId = 8;
		Make make = entityManager.find(Make.class, makeId);
		
		List<Model> listModel = repo.findByMake(make);

//		List<Model> listModels = repo.findByMakeOrderByNameAsc(make);
		
		listModel.forEach(name->System.out.println(name.getMake()));
//
		assertThat(listModel.size()).isGreaterThan(0);

	}

}
