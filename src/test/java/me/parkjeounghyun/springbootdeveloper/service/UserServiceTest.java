package me.parkjeounghyun.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.parkjeounghyun.springbootdeveloper.config.error.exception.UserNotFoundException;
import me.parkjeounghyun.springbootdeveloper.domain.User;
import me.parkjeounghyun.springbootdeveloper.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void clear() {
        userRepository.deleteAll();
    }

    @DisplayName("findById: 없는 유저의 아이디를 찾으면 UserNotFoundException이 발생한다.")
    @Test
    public void userNotFound() {
        // then
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.findById(1L);
        });
    }
}