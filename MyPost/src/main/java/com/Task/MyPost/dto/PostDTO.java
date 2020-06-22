package com.Task.MyPost.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PostDTO {

	private Long ID;
	private String content;
	// can be done by using the enum and constom converter for the model mapper
	private boolean status;
	private Date postedAt;
	private UserDTO user;
}
