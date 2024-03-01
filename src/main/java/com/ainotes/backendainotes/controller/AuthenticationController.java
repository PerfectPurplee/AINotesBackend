package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.RegisterRequest;
import com.ainotes.backendainotes.service.UserReqistratiotionAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    UserReqistratiotionAuthService authService;

    @Autowired
    public AuthenticationController(UserReqistratiotionAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {

        authService.registerUser(registerRequest);

        return "user registered";

    }

    @GetMapping("/o")
    public ResponseEntity<String> oAuth2(@RequestParam String code) {
        return ResponseEntity.ok(code + " no way");

    }
}
