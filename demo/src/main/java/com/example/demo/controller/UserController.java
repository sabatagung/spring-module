package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Iterable<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public HttpEntity <User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}

//    @GetMapping
//    public HttpEntity<List<User>>listAll(){
//        return new ResponseEntity<>(userService.listAll(), HttpStatus.OK);
//    }