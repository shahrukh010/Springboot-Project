package com.shopme.shopingCart;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Product;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

	public List<CartItem> findByCustomer(Customer customer);

	public CartItem findByCustomerAndProduct(Customer customer, Product product);

	public void updateQuantity(int quantity, Product product, Customer customer);

}
