package com.example.Oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
                    try {
                        auth.requestMatchers("/").permitAll().anyRequest().authenticated();
                    } catch (Exception e) {
                        log.error("security filter chain failed", e);
                    }
                }).oauth2Login(Customizer.withDefaults()).build();
    }
}
