package com.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/account")
	public String account() {

		return "customer account details";
	}

	@GetMapping("/balance")
	public String balance() {

		return "customer balance info";
	}

	@GetMapping("/loan")
	public String loan() {

		return "customer loan info";
	}

	@GetMapping("/card")
	public String carDetail() {
		return "customer cardDetails";
	}

	@GetMapping("/notice")
	public String notice() {
		return "customer notice details";
	}

	@GetMapping("/contact")
	public String contact() {

		return "customer contact details";
	}

}
