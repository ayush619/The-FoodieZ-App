package com.ayush.springmvcboot.service.impl;

import com.ayush.springmvcboot.model.LoginInfo;
import com.ayush.springmvcboot.model.LoginResponse;
import com.ayush.springmvcboot.model.User;
import com.ayush.springmvcboot.repository.UserRepository;
import com.ayush.springmvcboot.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService
{
    UserRepository userRepository;
    public LoginServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<LoginResponse> checkUser(String email)
    {
        Optional<User> userOptional = userRepository.findById(email);
        if(userOptional.isPresent())
        {
            return ResponseEntity.ok(LoginResponse.builder().message("Login Successful").build());
        }
        return ResponseEntity.badRequest().body(LoginResponse.builder().message("wrong credentials").build());

    }
}
