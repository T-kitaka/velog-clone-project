package com.spring.velogcloneproject.user.domain;

public class User {
    private Long id; // 유저 고유 번호
    private String name; // 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private String profileSummary; // 한줄 소개
    private String profileImage; // 프로필 이미지
    private String blogTitle; // 블로그 제목

    public User(Long id, String name, String email, String password, String profileSummary, String profileImage, String blogTitle) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileSummary = profileSummary;
        this.profileImage = profileImage;
        this.blogTitle = blogTitle;
    }

    public String getEmail() {
        return email;
    }
}
