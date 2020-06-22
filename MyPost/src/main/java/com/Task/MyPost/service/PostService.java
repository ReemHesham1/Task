package com.Task.MyPost.service;

import java.util.List;

import com.Task.MyPost.entity.PostEntity;

public interface PostService {

	PostEntity save(PostEntity post, Long id);

	List<PostEntity> search(String searchText);

}
