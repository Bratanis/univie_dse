package com.example.Task6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class greets people, whenever they go on localhost:8080
 */
@RestController
public class HomeCtl {

	@GetMapping("/")
	public String greet() {
		return "Welcome to the home screen! "
				+ "This app is just a server stub. "
				+ "For now it only has integration tests.";
	}
}
