package com.spring.velogcloneproject.post.repository;

import com.spring.velogcloneproject.post.domain.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(Long id);

    Optional<Post> findByUserId(Long userId);
}
