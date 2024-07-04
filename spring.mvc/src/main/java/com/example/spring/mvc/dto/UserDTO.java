package com.example.spring.mvc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
//    @NotBlank(message = "Name is mandatory")
//    @NotNull
    @NotEmpty
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    // getters and setters
}

//Option 1: Validating Controller Method Parameters
//You can annotate individual method parameters in your controller with @Validated and @RequestParam, @PathVariable, or @RequestBody annotations along with validation constraints:
//
//java
//Copy code
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//@Validated
//public class UserController {
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(
//            @RequestParam @NotBlank(message = "Name is mandatory") String name,
//            @RequestParam @Email(message = "Email should be valid") String email) {
//
//        // Process the parameters
//        // You can handle them directly or use them to populate a DTO and then validate further
//
//        return ResponseEntity.ok("User registered successfully: " + name + ", " + email);
//    }
//}
//In this example:
//
//@Validated is used at the class level to enable method validation.
//Each method parameter (name and email) is annotated with validation annotations (@NotBlank and @Email) directly.
//        Option 2: Using Method Arguments and BindingResult
//You can also use BindingResult to capture validation errors if you prefer handling errors more explicitly:
//
//java
//Copy code
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(
//            @RequestParam @NotBlank(message = "Name is mandatory") String name,
//            @RequestParam @Email(message = "Email should be valid") String email,
//            BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
//        }
//
//        // Process the parameters
//        // You can handle them directly or use them to populate a DTO and then validate further
//
//        return ResponseEntity.ok("User registered successfully: " + name + ", " + email);
//    }
//}
//Option 3: Validating Raw JSON Request Body
//If you're sending a complex JSON object and want to validate it without binding it directly to a DTO, you can use @Valid annotation along with @RequestBody:
//
//java
//Copy code
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//@Validated
//public class UserController {
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody Map<String, Object> requestBody, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
//        }
//
//        String name = (String) requestBody.get("name");
//        String email = (String) requestBody.get("email");
//
//        // Process the parameters or convert to DTO and validate further
//
//        return ResponseEntity.ok("User registered successfully: " + name + ", " + email);
//    }
//}
//In this example:
//
//@Valid is used with @RequestBody to validate the entire request body as a Map<String, Object>.
//You can then retrieve individual fields (name and email) from the map and perform further processing or convert them to a
//    DTO for additional validation.

//jpa, postgre, web, devtools, lombok

//continue generate from Controller Validation Example:

//{
//        "name" : "namyy",
//        "email": "ags3@gmail.com"
//        }
//
//i want my name property cannot assign with , number, and " ", and "(numbers)".
//the input validation usually on model, like adding annotation @Notnull , @NotBlank, @NotEmpty. but its not enough so
//we need to add input validation, where is the best practice to create input validation, in service or contoller


