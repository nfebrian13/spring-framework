package com.mvc.conference.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

	@GetMapping("registration")
	public String getRegistration(Map<String, Object> model) {
		model.put("registration", "Hello Nana!");
		return "registration";
	}
}
