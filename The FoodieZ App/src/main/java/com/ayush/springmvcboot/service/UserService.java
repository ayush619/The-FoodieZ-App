package com.ayush.springmvcboot.service;

import com.ayush.springmvcboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService
{
    /*
    Create
    Retrieve
    Update
    Delete
     */
     ResponseEntity<User> saveUser(User user);

     User getUser(String usserId);


     User deleteUser(String userId);

     User updateUser(String userId);
}
