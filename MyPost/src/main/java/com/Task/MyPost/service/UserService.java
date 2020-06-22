package com.Task.MyPost.service;

import com.Task.MyPost.entity.UserEntity;

public interface UserService {

	UserEntity save(UserEntity user);

	UserEntity logIn(String username, String password);
}
