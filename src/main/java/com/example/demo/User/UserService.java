package com.example.demo.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity registerUser(UserRegistrationDto dto) {
        UserEntity user = new UserEntity();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setBirthDay(dto.getBirthDay());
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity updateUser(Integer id, UserRegistrationDto dto) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setBirthDay(dto.getBirthDay());
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

