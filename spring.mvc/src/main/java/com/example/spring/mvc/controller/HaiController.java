package com.example.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HaiController {

        @RequestMapping( path = "/hello")
        public void Hai (HttpServletRequest request, HttpServletResponse response) throws IOException {
            String name = request.getParameter("name");
            if(name == null){
                name = "Guest";
            }
            response.getWriter().println("hai");
        }
    }


