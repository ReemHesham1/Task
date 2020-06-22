package com.Task.MyPost.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.Task.MyPost.entity.PostEntity;
import com.Task.MyPost.entity.UserEntity;
import com.Task.MyPost.repositories.PostRepository;
import com.Task.MyPost.service.PostService;
import com.Task.MyPost.utils.ErrorConstants;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;

	@Override
	@Transactional(readOnly = false)
	public PostEntity save(PostEntity post, Long id) {
		Assert.notNull(post, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		UserEntity user = new UserEntity();
		user.setId(id);
		// to be change to ennum isSatstus by default if null will be false = 0 public
		if (post.getPostedAt() == null) {
			post.setPostedAt(new Date());
		}
		post.setUser(user);
		return postRepo.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostEntity> search(String searchText) {
		Assert.hasText(searchText, ErrorConstants.MSG_ERROR_EMPTY_SEARCH_TEXT);
//		Pageable pagination = PageRequest.of((page.intValue() - 1), size.intValue());
//		List<PostEntity> postList = postRepo.search(PERCENT + searchText.toUpperCase() + PERCENT);
//		postList = postList.stream().filter(p -> p.isStatus() == false).collect(Collectors.toList());
		List<PostEntity> postList = postRepo.findByStatusAndContentContains(false, searchText);
		return postList;

	}

}
