package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private NameService nameService;

//    @Autowired
//    public UserService(NameService nameService) {
//        this.nameService = nameService;
//    }

    public String getUserName(String id) {
        System.out.println("id now: " + id);
        return nameService.getUserName(id);
    }

    public String getUserNameOnline(String id) {
        System.out.println("id now: " + id);
        return nameService.getUserNameByCallApi(id);
    }
}