package com.solthoth.emailservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("email")
public class EmailController {

    @GetMapping("")
    public String status() {
        return "ok";
    }
}
