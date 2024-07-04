package com.example.spring.dev.controller;

import com.example.spring.dev.model.User;
import com.example.spring.dev.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService service;

    @GetMapping
    public HttpEntity<List<User>> listAll() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<User> getOne(@PathVariable("id") String userId) {

        User user = service.get(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @PostMapping
    public HttpEntity<User> add(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable("id") String userId) {
        service.delete(userId);
        return ResponseEntity.noContent().build();
    }

}


