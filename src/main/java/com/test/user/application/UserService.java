package com.test.user.application;

import com.test.user.domain.User;
import com.test.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authentication(String token) {
        Long id = Long.parseLong(token);
        User user = userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return user;
    }
}
