package com.Task.MyPost.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Task.MyPost.dto.UserDTO;
import com.Task.MyPost.entity.UserEntity;
//import com.Task.MyPost.mapper.UserMapper;
import com.Task.MyPost.rest.api.UserRestApi;
import com.Task.MyPost.service.UserService;

@RestController
public class UserRestController implements UserRestApi {

	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper userMapper;

	public UserRestController(UserService userService, ModelMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = userMapper.map(userDTO, UserEntity.class);
		UserEntity userSaved = userService.save(userEntity);
		UserDTO user = userMapper.map(userSaved, UserDTO.class);
		return user;

	}

	@Override
	public void logIn(String username, String password) {

		UserEntity userSaved = userService.logIn(username, password);

	}

}
