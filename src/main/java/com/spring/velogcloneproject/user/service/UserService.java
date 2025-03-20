package com.spring.velogcloneproject.user.service;

import com.spring.velogcloneproject.user.domain.User;
import com.spring.velogcloneproject.user.domain.dto.UserDTO;
import com.spring.velogcloneproject.user.domain.dto.UserRegisterResponseDTO;
import com.spring.velogcloneproject.common.exception.ErrorCode;
import com.spring.velogcloneproject.common.exception.CustomException;
import com.spring.velogcloneproject.user.repository.UserRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepositoryV1 userRepositoryV1;

    @Autowired
    public UserService(UserRepositoryV1 userRepositoryV1) {
        this.userRepositoryV1 = userRepositoryV1;
    }

    public UserRegisterResponseDTO saveUser(UserDTO userDTO) {
        Optional<User> user = existsByEmail(userDTO.getEmail());
        if (user.isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXISTS);
        }

        // 저장 시도
        try {
            User savedUser = userRepositoryV1.save(userDTO);
            if (savedUser == null) {
                throw new CustomException(ErrorCode.USER_SAVED_FAILED); // 저장 실패
            }
        } catch (Exception e) {
            throw new CustomException(ErrorCode.USER_SAVED_FAILED); // 저장 실패
        }
        return new UserRegisterResponseDTO(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    // 이메일 중복 확인
    public Optional<User> existsByEmail(String email) {
        return userRepositoryV1.findByEmail(email);
    }
}
