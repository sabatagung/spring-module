package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping ("api/welcome")
public class HelloController {

    @GetMapping
    public String welcome(){
        return "Hello Controller";
    }

        @RequestMapping(path="/hello"){
        public void hai(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String name =
        }
    }


}
