package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.authentication.AuthenticationResponse;
import com.ainotes.backendainotes.dto.authentication.LoginRequest;
import com.ainotes.backendainotes.dto.authentication.RegisterRequest;
import com.ainotes.backendainotes.service.AuthenticationService;
import com.ainotes.backendainotes.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationService authService;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest registerRequest) {

        authService.registerUser(registerRequest);


        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authService.authenticate(loginRequest);
        return ResponseEntity.ok(jwtService.generateToken(userDetails));


    }

    @GetMapping
    public String test() {
        return "You are connected";
    }
}
