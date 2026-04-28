package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.UserRequestDto;
import com.joaofeliciano.ecommerce_api.dto.UserResponseDto;
import com.joaofeliciano.ecommerce_api.entity.User;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.exception.InvalidUser;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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

    public UserResponseDto createUser(UserRequestDto dto) throws InvalidUser {
        if (userRepository.existsByEmail(dto.getEmail())){
            throw new InvalidUser("This Email is already to use");
        }
        User user = toEntity(dto);
        User saved = userRepository.save(user);
        return toResponseDto(saved);
    }

    public UserResponseDto findById(Long id) throws InvalidUser, InvalidId{
        if(!userRepository.existsById(id)){
            throw new InvalidUser("This ID is invalid.");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new InvalidId("This user is not found."));

        return toResponseDto(user);
    }

    public List<UserResponseDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto updateUser(Long id, UserRequestDto dto) throws InvalidUser, InvalidId{
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new InvalidUser("Invalid User.");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new InvalidId("This user is not found."));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setTypeUser(dto.getTypeUser());
        User updated = userRepository.save(user);
        return toResponseDto(updated);
    }

    public void deleteUser(Long id) throws InvalidId{
        User user = userRepository.findById(id)
                .orElseThrow(() -> new InvalidId("This user is not found."));

        userRepository.delete(user);
    }
}
