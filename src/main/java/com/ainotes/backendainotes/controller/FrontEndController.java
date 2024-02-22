package com.ainotes.backendainotes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backend")
public class FrontEndController {


    @PostMapping("/test")
    public String postTest(@RequestBody String string) {

        return string;
    }

    @GetMapping("/test/get")
    public String getTest() {
        return "Access granted";
    }


}
