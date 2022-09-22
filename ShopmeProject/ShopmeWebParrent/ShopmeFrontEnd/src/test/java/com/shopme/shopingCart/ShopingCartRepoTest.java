package com.shopme.shopingCart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShopingCartRepoTest {

	@Autowired
	private CartItemRepository cartRepo;
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void test() {

		Integer customerId = 1;
		Integer productId = 2;

		Customer customer = testEntityManager.find(Customer.class, customerId);
		Product product = testEntityManager.find(Product.class, productId);

		CartItem cartItem = new CartItem();
		cartItem.setCustomer(customer);
		cartItem.setProduct(product);
		cartItem.setQuantity(1);

		CartItem cartItem2 = new CartItem();
		cartItem2.setCustomer(new Customer(50));
		cartItem2.setProduct(new Product(60));
		cartItem2.setQuantity(3);

		cartRepo.save(cartItem2);
	}
}
