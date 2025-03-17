package com.spring.velogcloneproject.user.domain;

public class UserBuilder {
    private Long id; // 유저 고유 번호
    private String name; // 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private String profileSummary; // 한줄 소개
    private String profileImage; // 프로필 이미지
    private String blogTitle; // 블로그 제목

    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder profileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
        return this;
    }

    public UserBuilder profileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public UserBuilder blogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
        return this;
    }

    public User build() {
        return new User(id, name, email, password, profileSummary, profileImage, blogTitle);
    }
}
