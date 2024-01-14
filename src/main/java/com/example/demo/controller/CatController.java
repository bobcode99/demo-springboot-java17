package com.example.demo.controller;

import com.example.demo.service.CatService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @Autowired
    CatService catService;

    @Autowired
    UserService userService;

    @GetMapping("/ping")
    public String sayPong() {
        return "pong";
    }

    @GetMapping("/api/cats")
    public int getWeight() {
        return catService.getSumOfCatWeights();
    }

    @GetMapping("/api/user")
    public String getUser() {
        return userService.getUserName("3");
    }

    @GetMapping("/api/userOnline")
    public String getUser1() {
        return userService.getUserNameOnline("345345");
    }
}
