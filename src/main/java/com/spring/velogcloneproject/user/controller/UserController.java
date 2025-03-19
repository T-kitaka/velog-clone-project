package com.spring.velogcloneproject.user.controller;

import com.spring.velogcloneproject.user.domain.dto.UserDTO;
import com.spring.velogcloneproject.user.domain.dto.UserRegisterResponseDTO;
import com.spring.velogcloneproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserRegisterResponseDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

}
