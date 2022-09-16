package com.shopme.customer;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopme.Utility;
import com.shopme.setting.EmailSettingBag;
import com.shopme.setting.SettingService;

@Controller
public class ResetPasswordController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private SettingService settingService;

	@GetMapping("/forgot_password")
	public String showRequestForm() {

		return "/customer/forgot_password_form";
	}

	@PostMapping("/forgot_password")
	public String processRequestForm(HttpServletRequest httpRequest, Model model) {

		try {
			String email = httpRequest.getParameter("email");
			String token = customerService.updateResetPasswordToken(email);
			System.out.println("Email:" + email);
			String link = Utility.getSiteURL(httpRequest) + "/reset_password?token=" + token;
			sendEmail(link, email);
			model.addAttribute("message", "Check link for reset password");
		} catch (CustomerNotFoundException ex) {

			model.addAttribute("error", ex.getMessage());

		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "could not send email");
		}
		return "/customer/forgot_password_form";
	}

	public void sendEmail(String link, String email) throws UnsupportedEncodingException, MessagingException {

		EmailSettingBag emailSettings = settingService.getEmailSettings();
		JavaMailSender mailSender = Utility.parepareMailSender(emailSettings);
		String address = email;
		String subject = "Here's the link to reset your password";
		String content = "<p>Hello, </p>" + "<p>You have requested to reset password</p>"
				+ "<p>click the link below to change your password</p>" + "<p><a href=\"" + link
				+ "\"> change my password</a></p>" + "<br>"
				+ "<p> If you did not make this request then please ignore this email</p>";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(emailSettings.getFromEmailAddress(), emailSettings.getSenderName());
		helper.setTo(address);
		helper.setSubject(subject);
		helper.setText(content, true);
	}
}
