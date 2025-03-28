package com.spring.velogcloneproject.user.domain.dto;

public class UserRegisterResponseDTO {
    Long id;
    String name;
    String email;

    public UserRegisterResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
