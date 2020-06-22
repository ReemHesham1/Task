package com.Task.MyPost.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Task.MyPost.dto.PostDTO;
import com.Task.MyPost.entity.PostEntity;
import com.Task.MyPost.rest.api.PostRestApi;
import com.Task.MyPost.service.PostService;

@RestController
public class PostRestController implements PostRestApi {

	@Autowired
	private PostService postService;
	@Autowired
	private ModelMapper postMapper;

	public PostRestController(PostService postService, ModelMapper postMapper) {
		super();
		this.postService = postService;
		this.postMapper = postMapper;
	}

	@Override
	public PostDTO createPost(PostDTO postDTO, Long id) {
		PostEntity post = postMapper.map(postDTO, PostEntity.class);
		PostEntity postSaved = postService.save(post, id);
		PostDTO postdto = postMapper.map(postSaved, PostDTO.class);
		return postdto;
	}

	@Override
	public ResponseEntity<List<PostDTO>> searchPost(String searchText) {
		List<PostEntity> postList = postService.search(searchText);
		List<PostDTO> mapList = postList.stream().map(postSearch -> postMapper.map(postSearch, PostDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

}
