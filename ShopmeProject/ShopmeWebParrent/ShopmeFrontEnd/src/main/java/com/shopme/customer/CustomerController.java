package com.shopme.customer;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.Utility;
import com.shopme.common.entity.Country;
import com.shopme.common.entity.Customer;
import com.shopme.security.CustomerUserDetails;
import com.shopme.security.oauth.CustomerOauthUser;
import com.shopme.setting.EmailSettingBag;
import com.shopme.setting.SettingService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private SettingService settingService;

	@GetMapping("/register")
	public String showRegisterForm(Model model) {

		List<Country> listCountries = customerService.listAllCountries();
		model.addAttribute("listCountries", listCountries);
		model.addAttribute("pageTitle", "Customer Registration");
		model.addAttribute("customer", new Customer());

		return "register/register_form";
	}

	@PostMapping("/create_customer")
	public String createCustomer(Customer customer, Model model, HttpServletRequest http)
			throws UnsupportedEncodingException, MessagingException {

		customerService.registerCustomer(customer);
		sendVerificationEmail(http, customer);
		model.addAttribute("pageTitle", "Registration succeed!");
		customerService.saveCustomer(customer);

		return "register/register_success";
	}

	private void sendVerificationEmail(HttpServletRequest http, Customer customer)
			throws UnsupportedEncodingException, MessagingException {

		EmailSettingBag emailSettings = settingService.getEmailSettings();
		JavaMailSender mailSender = Utility.parepareMailSender(emailSettings);

		String toAddress = customer.getEmail();
		String subject = emailSettings.getCustomerVerifySubject();
		String content = emailSettings.getCustomerVerifyContent();

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(emailSettings.getFromEmailAddress(), emailSettings.getSenderName());
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", customer.getFullName());
		String verifyURL = Utility.getSiteURL(http) + "/verify?code=" + customer.getVerificationCode();
		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);
		mailSender.send(message);
		System.out.println("to address: " + toAddress);
		System.out.println("Verify URL:" + verifyURL);

	}

	@GetMapping("/verify")
	public String verifyAccount(@Param("code") String code, Model model) {

		Boolean verify = customerService.verify(code);

		return "/register/" + (verify ? "verify_success" : "verify_fail");
	}

	@GetMapping("/account_details")
	public String viewAccountDetails(Model model, HttpServletRequest httpServletRequest) {

		// get user authentication type like email or ....
//		String principalType = httpServletRequest.getUserPrincipal().getName();
//		System.out.println(principalType);
		String customerMail = getEmailOfAuthenticateCustomer(httpServletRequest);
		Customer customer = customerService.getCustomerByEmail(customerMail);
		List<Country> listCountries = customerService.listAllCountries();
		model.addAttribute("customer", customer);
		model.addAttribute("listCountries", listCountries);
		return "customer/account_form";

	}

	private String getEmailOfAuthenticateCustomer(HttpServletRequest httpRequest) {

		Object principal = httpRequest.getUserPrincipal();
		String userEmail = null;

		if (principal instanceof UsernamePasswordAuthenticationToken
				|| principal instanceof RememberMeAuthenticationToken)
			userEmail = httpRequest.getUserPrincipal().getName();

		else if (principal instanceof OAuth2AuthenticationToken) {

			OAuth2AuthenticationToken oauth = (OAuth2AuthenticationToken) principal;
			CustomerOauthUser customOAuth = (CustomerOauthUser) oauth.getPrincipal();
			userEmail = customOAuth.getEmail();
		}
		return userEmail;

	}

	@PostMapping("/update_account_details")
	public String updateAccountDetails(Model model, Customer customer, RedirectAttributes redirectAttributes,
			HttpServletRequest httpRequest) {

		customerService.update(customer);

		redirectAttributes.addFlashAttribute("message", "Your account details have been update");
		updateNameForAuthenticateCustomer(customer, httpRequest);

		return "redirect:/account_details";
	}

	public void updateNameForAuthenticateCustomer(Customer customer, HttpServletRequest httpRequest) {

		Object principal = httpRequest.getUserPrincipal();
		String fullName = customer.getFirstName() + " " + customer.getLastName();

		if (principal instanceof UsernamePasswordAuthenticationToken
				|| principal instanceof RememberMeAuthenticationToken) {

			CustomerUserDetails customerUserDetails = getCustomerUserDetailsObject(principal);
			Customer authenticateCustomer = customerUserDetails.getCustomer();
			authenticateCustomer.setFirstName(customer.getFirstName());
			authenticateCustomer.setLastName(customer.getLastName());
		}

		else if (principal instanceof OAuth2AuthenticationToken) {

			OAuth2AuthenticationToken oauth = (OAuth2AuthenticationToken) principal;
			CustomerOauthUser customOAuth = (CustomerOauthUser) oauth.getPrincipal();
			customOAuth.setFullName(fullName);
		}
	}

	private CustomerUserDetails getCustomerUserDetailsObject(Object principal) {

		CustomerUserDetails userDetails = null;

		if (principal instanceof UsernamePasswordAuthenticationToken) {

			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
			userDetails = (CustomerUserDetails) token.getPrincipal();

		} else if (principal instanceof RememberMeAuthenticationToken) {
			RememberMeAuthenticationToken token = (RememberMeAuthenticationToken) principal;
			userDetails = (CustomerUserDetails) principal;
		}

		return userDetails;
	}
}
