package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetailsils loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            UserDetails user = User.withUsername("admin")
                    .password(new BCryptPasswordEncoder().encode("admin"))
                    .roles("ADMIN")
                    .build();
            return user;
        } else if (username.equals("user")) {
            UserDetails user = User.withUsername("user")
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .roles("USER")
                    .build();
            return user;
        } else if (username.equals("moderator")) {
            UserDetails user = User.withUsername("moderator")
                    .password(new BCryptPasswordEncoder().encode("moderator"))
                    .roles("MODERATOR")
                    .build();
            return user;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}
