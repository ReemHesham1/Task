package com.Task.MyPost.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task.MyPost.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

//	@Query(value = "SELECT  post " + "FROM PostEntity post " + "WHERE UPPER(post.content) LIKE :content")
//	List<PostEntity> search(String content);

	List<PostEntity> findByStatusAndContentContains(boolean b, String string);

}
