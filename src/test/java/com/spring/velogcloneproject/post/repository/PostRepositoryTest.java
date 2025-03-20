package com.spring.velogcloneproject.post.repository;

import com.spring.velogcloneproject.post.domain.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class PostRepositoryTest {
    PostMemoryRepositoryImpl repository = new PostMemoryRepositoryImpl();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        LocalDateTime now = LocalDateTime.now();
        Post post = new Post(null, 0L, "test", "testtest", now, now);

        repository.save(post);

        Optional<Post> result = repository.findById(post.getId());

        assertThat(result).isPresent();
        assertThat(post).isEqualTo(result.get());
    }

    @Test
    void findById() {
        LocalDateTime now = LocalDateTime.now();
        Post post = new Post(null, 0L, "test", "testtest", now, now);

        repository.save(post);

        Optional<Post> result = repository.findById(post.getId());

        assertThat(result).isPresent();
    }

    @Test
    void findByUserId() {
        LocalDateTime now = LocalDateTime.now();
        Post post = new Post(null, 123L, "test", "testtest", now, now);

        repository.save(post);

        Optional<Post> result = repository.findByUserId(post.getUserId());

        assertThat(result).isPresent();
        assertThat(post.getUserId()).isEqualTo(result.get().getUserId());
    }
}