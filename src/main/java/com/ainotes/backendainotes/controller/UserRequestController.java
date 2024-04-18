package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.service.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRequestController {

    UserDetailsServiceImpl userDetailsService;


    @PostMapping("/getNotes")
    public String getAllUserNotes() {
        return null;
    }

    @GetMapping("/test/get")
    public String getTest() {
        return "Access granted";
    }


}
