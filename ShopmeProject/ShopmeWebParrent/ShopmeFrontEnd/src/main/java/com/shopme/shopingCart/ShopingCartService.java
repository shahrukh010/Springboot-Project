package com.shopme.shopingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.CartItem;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Product;

@Service
public class ShopingCartService {

	@Autowired
	private CartItemRepository cartRepo;

	public List<CartItem> listCartItems(Customer customer) {

		return cartRepo.findByCustomer(customer);
	}

	public Integer addProduct(Integer productId, Integer quantity, Customer customer) throws ShopingCartException {

		Integer updateQuantity = quantity;

		Product product = new Product(productId);
		CartItem cartItem = cartRepo.findByCustomerAndProduct(customer, product);

		if (cartItem != null) {

			updateQuantity = cartItem.getQuantity() + updateQuantity;
			if (updateQuantity > 5) {

				throw new ShopingCartException("Could not add more " + quantity + " item(s)"
						+ "because there's already " + cartItem.getQuantity() + " item(s) "
						+ "in your shoping cart.Maximum allowed only 5.");
			}
			cartItem.setQuantity(updateQuantity);
		} else {
			cartItem = new CartItem();
			cartItem.setCustomer(customer);
			cartItem.setProduct(product);
		}
		cartItem.setQuantity(updateQuantity);
		cartRepo.save(cartItem);
		return updateQuantity;
	}

}
