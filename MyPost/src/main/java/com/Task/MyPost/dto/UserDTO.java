package com.Task.MyPost.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

	private Long ID;
	private String username;
	private String firstname;
	private String password;
	private Date createdAt;
}
