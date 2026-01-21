package com.ayush.springmvcboot.repository;

import com.ayush.springmvcboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String>
{

}
