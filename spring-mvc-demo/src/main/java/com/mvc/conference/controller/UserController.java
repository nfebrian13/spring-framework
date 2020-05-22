package com.mvc.conference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.conference.model.User;

@RestController
public class UserController {

	@GetMapping("/user")
	public User getUser(@RequestParam(value = "firstname", defaultValue = "Nana") String firstname,
			@RequestParam(value = "lastname", defaultValue = "Febriana") String lastname,
			@RequestParam(value = "age", defaultValue = "27") int age) {

		User user = new User();
		user.setFirtname(firstname);
		user.setLastname(lastname);
		user.setAge(age);

		return user;
	}

	@PostMapping("/user")
	public User postUser(User user) {
		System.out.println("User firstname: " + user.getFirtname());
		return user;
	}

}
