package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.UserReqistrationDTO;
import com.ainotes.backendainotes.service.UserReqistratiotionAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserReqistrationController {

    UserReqistratiotionAuthService authService;

    @Autowired
    public UserReqistrationController(UserReqistratiotionAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserReqistrationDTO userReqistrationDTO) {

        authService.registerUser(userReqistrationDTO);

        return "user registered";

    }
}
