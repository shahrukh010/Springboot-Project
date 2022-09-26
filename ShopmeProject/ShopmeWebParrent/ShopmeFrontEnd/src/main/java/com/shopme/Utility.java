package com.shopme;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.shopme.security.oauth.CustomerOauthUser;
import com.shopme.setting.EmailSettingBag;

public class Utility {

	public static String getSiteURL(HttpServletRequest httpServletRequest) {

		String siteURL = httpServletRequest.getRequestURL().toString();

		return siteURL.replace(httpServletRequest.getServletPath(), "");
	}

	public static JavaMailSender parepareMailSender(EmailSettingBag settings) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(settings.getHost());
		mailSender.setPort(settings.getPort());
		mailSender.setUsername(settings.getUsername());
		mailSender.setPassword(settings.getPassword());

		Properties mailProperties = new Properties();
		mailProperties.setProperty("mail.smtp.auth", settings.getSmtpAuth());
		mailProperties.setProperty("mail.smtp.starttls.enable", settings.getSmtpSecured());
		mailSender.setJavaMailProperties(mailProperties);

		return mailSender;

	}

	public static String getEmailOfAuthenticateCustomer(HttpServletRequest httpRequest) {

		Object principal = httpRequest.getUserPrincipal();
		if (principal == null)
			return null;

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
}
