package com.example.spring.dev.repository;

import com.example.spring.dev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String>  {

}
