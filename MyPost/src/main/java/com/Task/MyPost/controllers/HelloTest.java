package com.Task.MyPost.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {

	@GetMapping(path = "/")
	public String sayHello() {
		return "Hello Test!!??";
	}

}
