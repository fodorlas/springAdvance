package com.gfa.springadvanced.services;

import com.gfa.springadvanced.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(String username, String password, String email);
}
