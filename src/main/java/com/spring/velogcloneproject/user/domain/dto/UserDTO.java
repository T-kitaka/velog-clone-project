package com.spring.velogcloneproject.user.domain.dto;

public class UserDTO {
    private Long id;
    private String name; // 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private String profileSummary; // 한줄 소개
    private String profileImage; // 프로필 이미지
    private String blogTitle; // 블로그 제목

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
