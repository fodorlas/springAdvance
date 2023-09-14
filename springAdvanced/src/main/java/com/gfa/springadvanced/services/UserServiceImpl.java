package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.DTOs.UserRegisterDTO;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String username, String password, String email) throws IllegalArgumentException{
        Optional<User> optionalUser = findUserByUsername(username);
        if (optionalUser.isPresent()) throw new IllegalArgumentException("User already exists");
        User user = new User(username, password, email);

        return userRepository.save(user);
    }

    @Override
    public User registerUser(User user) throws IllegalArgumentException{
        Optional<User> optionalUser = findUserByUsername(user.getUsername());
        if (optionalUser.isPresent()) throw new IllegalArgumentException("User already exists");
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User convertUserRegistrationDTO(UserRegisterDTO userRegisterDTO) {

        if (userRegisterDTO.getPassword1().equals(userRegisterDTO.getPassword2()) &&
                !userRegisterDTO.getUsername().isEmpty() &&
                !userRegisterDTO.getEmail().isEmpty()) {
            return new User(userRegisterDTO.getUsername(), userRegisterDTO.getPassword1(), userRegisterDTO.getEmail());
        }
        return null;
    }


}
