package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.AuthenticationResponse;
import com.ainotes.backendainotes.dto.LoginRequest;
import com.ainotes.backendainotes.dto.RegisterRequest;
import com.ainotes.backendainotes.service.AuthenticationService;
import com.ainotes.backendainotes.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping()
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authService.authenticate(loginRequest);
        return ResponseEntity.ok(jwtService.generateToken(userDetails));


    }
}
