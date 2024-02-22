package com.ainotes.backendainotes.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class FrontEndController {


    @PostMapping("/test")
    public String postTest(@RequestBody String string) {

        return string;
    }


}
