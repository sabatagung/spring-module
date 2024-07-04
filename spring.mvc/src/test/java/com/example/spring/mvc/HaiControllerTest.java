package com.example.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//import static org.springframework.test.web.servlet.MockMvcBuilder.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
public class HaiControllerTest {
    @Autowired
    private MockMvc mockMvc;

}
