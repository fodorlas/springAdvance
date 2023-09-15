package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.DTOs.LoginRequestDTO;
import com.gfa.springadvanced.models.DTOs.UserRegisterDTO;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.services.UserService;
import com.gfa.springadvanced.services.springsecurityservices.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private JwtService jwtService;


    @Autowired
    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtService jwtService) {

        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

//    @PostMapping("/api/register")
//    public ResponseEntity<String> registerUser(@RequestBody(required = false) UserRegisterDTO userRegisterDTO) {public ResponseEntity<String> registerUser() {
//
//        return ResponseEntity.ok("All good");
//    }


    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {

        User savedUser = null;
        ResponseEntity response = null;
        try {
            User user = userService.convertUserRegistrationDTO(userRegisterDTO);
            String hashPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPwd);
            savedUser = userService.registerUser(user);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

    @PostMapping("/api/login")
    public String authenticateAndGetToken(@RequestBody LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequestDTO.getUsername());
        }

        throw new UsernameNotFoundException("invalid user details.");
    }

    @GetMapping("/api/isRunning")
    public String isRunning() {
        return "Service is running";
    }

}
