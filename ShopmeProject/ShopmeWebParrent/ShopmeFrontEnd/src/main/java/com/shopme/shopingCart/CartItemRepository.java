package com.shopme.shopingCart;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Product;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

	//Query method
	public List<CartItem> findByCustomer(Customer customer);

	//Query method
	public CartItem findByCustomerAndProduct(Customer customer, Product product);

	@Modifying
	@Query("UPDATE CartItem c SET c.quantity=?1 where c.customer.id=?2 AND c.product.id=?3")
	public void updateQuantity(int quantity, Integer customer, Integer product);

	@Modifying
	@Query("delete from CartItem c where c.customer.id=?1 AND c.product.id=?2")
	public void deleteByCustomerAndProduct(Integer customerId, Integer productId);
}
