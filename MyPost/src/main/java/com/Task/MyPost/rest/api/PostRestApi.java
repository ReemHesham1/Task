package com.Task.MyPost.rest.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Task.MyPost.dto.PostDTO;

@RequestMapping(value = "/api/post")
public interface PostRestApi {

	/**
	 * create new post related to the user with the id passed on @param id the userId should be come from token (if token authorization is
	 * used)
	 * 
	 * @return PostDTO created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	PostDTO createPost(@RequestBody PostDTO postDTO, @RequestParam(value = "id", defaultValue = "1", required = true) Long id);

	/**
	 * search post
	 * 
	 * @param search text
	 * @return Post with its user data
	 */
	@GetMapping
	public ResponseEntity<List<PostDTO>> searchPost(@RequestParam(name = "searchText", required = true) String searchText);
//			@RequestParam(value = "page", defaultValue = "1", required = false) Long page,
//			@RequestParam(value = "size", defaultValue = "100", required = false) Long size);
}
