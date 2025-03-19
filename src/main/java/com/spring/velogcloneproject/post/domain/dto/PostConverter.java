package com.spring.velogcloneproject.post.domain.dto;

import com.spring.velogcloneproject.post.domain.Post;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class PostConverter implements Converter<PostCreateRequest, Post> {
    @Override
    public Post convert(MappingContext<PostCreateRequest, Post> mappingContext) {
        PostCreateRequest source = mappingContext.getSource();
        Post post = new Post();
        post.setUserId(source.getUserId());
        post.setTitle(source.getTitle());
        post.setContent(source.getContent());
        return post;
    }
}
