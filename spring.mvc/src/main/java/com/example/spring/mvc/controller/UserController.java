package com.example.spring.mvc.controller;

import com.example.spring.mvc.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody Map<String, Object> requestBody, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }

        // Process valid user data
        String name = (String) requestBody.get("name");
        String email = (String) requestBody.get("email");
        // userService.registerUser(userDTO);

        return ResponseEntity.ok("User registered successfully");
    }

//    // Simulate registration logic
//        return ResponseEntity.ok("User registered successfully: " + userDTO.getName() + ", " + userDTO.getEmail());
}

//@PostMapping("/register")
//public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//        // Handle validation errors
//        return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
//    }
//
//    // Process valid user data
//    // userService.registerUser(userDTO);
//
//    return ResponseEntity.ok("User registered successfully");
//}
//
////    // Simulate registration logic
////        return ResponseEntity.ok("User registered successfully: " + userDTO.getName() + ", " + userDTO.getEmail());
//}