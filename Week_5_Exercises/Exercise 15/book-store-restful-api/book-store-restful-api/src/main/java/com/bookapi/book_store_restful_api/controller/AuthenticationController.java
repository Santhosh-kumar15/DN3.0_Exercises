package com.bookapi.book_store_restful_api.controller;

import com.bookapi.book_store_restful_api.security.JwtUtil;
import com.bookapi.book_store_restful_api.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        // Authenticate user and generate token
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return token;
    }
}
