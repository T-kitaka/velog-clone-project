package com.spring.velogcloneproject.post.repository;

import com.spring.velogcloneproject.post.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostMemoryRepositoryImpl implements PostRepository {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(sequence.incrementAndGet());
        }

        posts.put(post.getId(), post);

        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.of(posts.get(id));
    }

    @Override
    public Optional<Post> findByUserId(Long userId) {
        return posts
                .values()
                .stream()
                .filter((post) -> post.getUserId().equals(userId))
                .findAny();
    }

    public void clearStore() {
        posts.clear();
    }
}
