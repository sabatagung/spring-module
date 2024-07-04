package com.example.spring.dev.service;

import com.example.spring.dev.model.User;
import com.example.spring.dev.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> listAll() {
        return repo.findAll();
    }

    @Override
    public User get (String userId) {
        return repo.findById(userId).get();
    }
    @Override
    public User save (User user) {
        return  repo.save(user);
    }
    @Override
    public void delete (String userId){
        repo.deleteById(userId);
    }



}
