package com.spring.velogcloneproject.post.controller;

import com.spring.velogcloneproject.post.domain.dto.PostCreateRequest;
import com.spring.velogcloneproject.post.domain.dto.PostCreateResponse;
import com.spring.velogcloneproject.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public PostCreateResponse createPost(@RequestBody PostCreateRequest postCreateRequest) {
        return postService.createPost(postCreateRequest);
    }
}
