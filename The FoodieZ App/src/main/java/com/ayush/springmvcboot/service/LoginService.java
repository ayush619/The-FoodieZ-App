package com.ayush.springmvcboot.service;

import com.ayush.springmvcboot.model.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService
{
    ResponseEntity<LoginResponse> checkUser(String email);
}
