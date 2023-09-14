package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.DTOs.UserRegisterDTO;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.services.MovieServices;
import com.gfa.springadvanced.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
//
//        User savedUser = null;
//        ResponseEntity response = null;
//        try {
//            User user = userService.convertUserRegistrationDTO(userRegisterDTO);
//            String hashPwd = passwordEncoder.encode(user.getPassword());
//            user.setPassword(hashPwd);
//            savedUser = userService.registerUser(user);
//            if (savedUser.getId() > 0) {
//                response = ResponseEntity
//                        .status(HttpStatus.CREATED)
//                        .body("Given user details are successfully registered");
//            }
//        } catch (Exception ex) {
//            response = ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An exception occured due to " + ex.getMessage());
//        }
//        return response;
//    }

//    @PostMapping("/registration")
//    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
//
//        return ResponseEntity.ok("All good");
//    }


}
