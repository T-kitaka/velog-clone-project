package com.spring.velogcloneproject.user.repository;

import com.spring.velogcloneproject.user.domain.User;
import com.spring.velogcloneproject.user.domain.dto.UserDTO;

import java.util.Optional;

public interface UserRepositoryV1 {
    User save(UserDTO userDTO);
    Optional<User> findByEmail(String email);
}
