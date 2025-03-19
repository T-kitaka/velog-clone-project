package com.spring.velogcloneproject.post.domain.dto;

import java.time.LocalDateTime;

public class PostCreateRequest {
    private Long userId;
    private String title;
    private String content;

    public PostCreateRequest() {
    }

    public PostCreateRequest(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
