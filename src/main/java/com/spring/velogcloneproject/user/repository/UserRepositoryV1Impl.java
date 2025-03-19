package com.spring.velogcloneproject.user.repository;

import com.spring.velogcloneproject.user.domain.User;
import com.spring.velogcloneproject.user.domain.UserBuilder;
import com.spring.velogcloneproject.user.domain.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// 인 메모리 형태
@Repository
public class UserRepositoryV1Impl implements UserRepositoryV1 {
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    // Thread-safe로 구현되어 멀티쓰레드에서 synchronized 없이 사용할 수 있습니다
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public User save(UserDTO userDTO) {
        // 유저 아이디가 null 경우
        if (userDTO.getId() == null) {
            userDTO.setId(sequence.incrementAndGet()); // incrementAndGet() : +1 증가시키고 변경된 값 리턴
        }

        User user = userMapping(userDTO);
        users.put(userDTO.getId(), user);
//        System.out.println(users);
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public User userMapping(UserDTO userDTO) {

        return new UserBuilder()
                .id(userDTO.getId())
                .blogTitle(userDTO.getBlogTitle())
                .profileImage(userDTO.getProfileImage())
                .profileSummary(userDTO.getProfileSummary())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .build();
    }
}
