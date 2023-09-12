package com.gfa.springadvanced.controllers;


import com.gfa.springadvanced.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.web.bind.annotation.RestController
public class ApiController {

    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }



}
