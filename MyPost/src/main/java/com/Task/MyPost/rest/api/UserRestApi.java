package com.Task.MyPost.rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Task.MyPost.dto.UserDTO;

@RequestMapping(value = "/api/user")
public interface UserRestApi {

	/**
	 * Add new user
	 * 
	 * @return UserDTO created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	UserDTO save(@RequestBody UserDTO userDTO);

	/**
	 * get user created (login)
	 * 
	 * @param username & password
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	void logIn(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password);
}
