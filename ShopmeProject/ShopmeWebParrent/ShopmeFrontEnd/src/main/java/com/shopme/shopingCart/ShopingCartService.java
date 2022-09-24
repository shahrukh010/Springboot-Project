package com.shopme.shopingCart;

import org.springframework.stereotype.Service;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Product;

@Service
public class ShopingCartService {

	private CartItemRepository cartRepo;

	public Integer addProduct(Integer productId, Integer quantity, Customer customer) {

		Integer updateQuantity = quantity;

		Product product = new Product(productId);
		CartItem cartItem = cartRepo.findByCustomerAndProduct(customer, product);

		if (cartItem != null) {

			updateQuantity = cartItem.getQuantity() + updateQuantity;
			cartItem.setQuantity(updateQuantity);
		} else {

			cartItem.setCustomer(customer);
			cartItem.setProduct(product);
		}
		cartItem.setQuantity(updateQuantity);
		cartRepo.save(cartItem);

		return updateQuantity;
	}

}
