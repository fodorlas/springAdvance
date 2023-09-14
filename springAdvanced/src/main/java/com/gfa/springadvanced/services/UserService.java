package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.DTOs.UserRegisterDTO;
import com.gfa.springadvanced.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User registerUser(String username, String password, String email);

    User registerUser(User user) throws IllegalArgumentException;

    Optional<User> findUserByUsername(String username);

    User convertUserRegistrationDTO(UserRegisterDTO userRegisterDTO);
}
