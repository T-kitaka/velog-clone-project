package com.spring.velogcloneproject.post.service;

import com.spring.velogcloneproject.config.ModelMapperConfig;
import com.spring.velogcloneproject.post.domain.dto.PostCreateRequest;
import com.spring.velogcloneproject.post.domain.dto.PostCreateResponse;
import com.spring.velogcloneproject.post.repository.PostMemoryRepositoryImpl;
import com.spring.velogcloneproject.post.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PostServiceTest {
    private PostService postService;
    private PostMemoryRepositoryImpl postRepository;
    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void beforeEach() {
        postRepository = new PostMemoryRepositoryImpl();
        context = new AnnotationConfigApplicationContext(ModelMapperConfig.class);
        postService = new PostService(postRepository, context.getBean(ModelMapper.class));
    }

    @AfterEach
    public void afterEach() {
        postRepository.clearStore();
    }

    @Test
    void createPost() {
        PostCreateRequest postCreateRequest = new PostCreateRequest(0L, "twetsd8", "1i324iwqrrdsl");

        PostCreateResponse postCreateResponse = postService.createPost(postCreateRequest);

        assertThat(postCreateResponse.getId()).isNotNull();
        assertThat(postCreateResponse.getTitle()).isEqualTo(postCreateRequest.getTitle());
        assertThat(postCreateResponse.getContent()).isEqualTo(postCreateRequest.getContent());
    }
}