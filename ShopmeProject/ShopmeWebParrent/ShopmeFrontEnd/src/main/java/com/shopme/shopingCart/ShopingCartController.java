package com.shopme.shopingCart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopingCartController {

	@Autowired
	private ShopingCartService cartService;

	@GetMapping("/cart")
	public String viewCart(Model model, HttpServletRequest request) {

		cartService.listCartItems(null);

		return "cart/shopping_cart";
	}
}
