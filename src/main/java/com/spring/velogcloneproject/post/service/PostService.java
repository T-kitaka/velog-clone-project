package com.spring.velogcloneproject.post.service;

import com.spring.velogcloneproject.post.domain.Post;
import com.spring.velogcloneproject.post.domain.dto.PostCreateRequest;
import com.spring.velogcloneproject.post.domain.dto.PostCreateResponse;
import com.spring.velogcloneproject.post.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public PostCreateResponse createPost(PostCreateRequest postCreateRequest) {
        LocalDateTime now = LocalDateTime.now();
        Post post = modelMapper.map(postCreateRequest, Post.class);
        post.setCreatedAt(now);
        post.setUpdatedAt(now);

        post = postRepository.save(post);

        return modelMapper.map(post, PostCreateResponse.class);
    }
}
