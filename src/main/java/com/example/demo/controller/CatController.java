package com.example.demo.controller;

import com.example.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping("/ping")
    public String sayPong() {
        return "pong";
    }

    @GetMapping("/api/cats")
    public int getWeight() {
        return catService.getSumOfCatWeights();
    }
}
