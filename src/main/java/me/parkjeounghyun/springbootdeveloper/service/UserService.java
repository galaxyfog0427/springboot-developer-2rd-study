package me.parkjeounghyun.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.parkjeounghyun.springbootdeveloper.config.error.exception.UserNotFoundException;
import me.parkjeounghyun.springbootdeveloper.domain.User;
import me.parkjeounghyun.springbootdeveloper.dto.AddUserRequest;
import me.parkjeounghyun.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
}
