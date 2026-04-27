package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.UserRequestDto;
import com.joaofeliciano.ecommerce_api.dto.UserResponseDto;
import com.joaofeliciano.ecommerce_api.entity.User;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private User toEntity(UserRequestDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setTypeUser(dto.getTypeUser());
        user.setCreationDateUser(LocalDateTime.now());
        return user;
    }

    private UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getIdUser(),
                user.getName(),
                user.getEmail(),
                user.getTypeUser(),
                user.getCreationDateUser()
        );
    }
}
