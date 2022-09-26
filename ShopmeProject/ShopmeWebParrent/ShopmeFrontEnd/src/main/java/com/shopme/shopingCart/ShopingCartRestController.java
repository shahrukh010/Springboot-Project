package com.shopme.shopingCart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopme.common.entity.Customer;

@RestController
public class ShopingCartRestController {

	@Autowired
	private ShopingCartService shopingCartService;

	@PostMapping("/cart/add/{productId}/{quantity}")
	public String addToCart(@PathVariable(name = "productId") Integer productId,
			@PathVariable(name = "quantity") Integer quantity, HttpServletRequest request) {

		return null;
	}

	private Customer getAuthenticateCustomer(HttpServletRequest request) {

		return null;
	}
}
