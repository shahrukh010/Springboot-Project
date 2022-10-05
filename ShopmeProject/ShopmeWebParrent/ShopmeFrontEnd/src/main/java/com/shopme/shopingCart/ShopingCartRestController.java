package com.shopme.shopingCart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopme.Utility;
import com.shopme.common.entity.Customer;
import com.shopme.customer.CustomerNotFoundException;
import com.shopme.customer.CustomerService;

@RestController
public class ShopingCartRestController {

	@Autowired
	private ShopingCartService shopingCartService;
	@Autowired
	private CustomerService customerService;

	@PostMapping("/cart/add/{productId}/{quantity}")
	public String addToCart(@PathVariable(name = "productId") Integer productId,
			@PathVariable(name = "quantity") Integer quantity, HttpServletRequest request) {

		try {
			Customer customer = getAuthenticateCustomer(request);
			// if customer is already login then add product into cart
			Integer updateQuantity = shopingCartService.addProduct(productId, quantity, customer);

			return updateQuantity + " item(s) of this product were added to your shoping cart";

		} catch (CustomerNotFoundException ex) {
			return "You must login to add this product into cart";
		}
	}

	private Customer getAuthenticateCustomer(HttpServletRequest request) throws CustomerNotFoundException {

		String customerEmail = Utility.getEmailOfAuthenticateCustomer(request);

		if (customerEmail == null)
			throw new CustomerNotFoundException("no customer found");

		return customerService.getCustomerByEmail(customerEmail);
	}
}
