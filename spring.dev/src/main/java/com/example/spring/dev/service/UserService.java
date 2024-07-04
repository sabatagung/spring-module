package com.example.spring.dev.service;

import com.example.spring.dev.model.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    User get (String userId);
    User save (User user);
    void delete (String userId);

}
