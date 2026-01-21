package com.ayush.springmvcboot.service.impl;

import com.ayush.springmvcboot.model.User;
import com.ayush.springmvcboot.repository.UserRepository;
import com.ayush.springmvcboot.service.UserService;
import com.mongodb.DuplicateKeyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String userId)
    {
       return userRepository.findById(userId).get();
//        return user.get();
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }

    @Override
    public User updateUser(String userId) {
        return null;
    }
    @Override
    public ResponseEntity<User> saveUser(User user)
    {
        try
        {
            log.info("created");
            User user1 = userRepository.insert(user);
            return new ResponseEntity<User>(user1, HttpStatus.OK);
        }
        catch (DuplicateKeyException e)
        {
            log.info("already present");
            return new ResponseEntity<User>(HttpStatus.valueOf(409) );
        }
    }
}
