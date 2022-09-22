package com.shopme.shopingCart;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
	
	
	public List<CartItem> findByCustomer(Customer customer);

}
