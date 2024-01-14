package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

    //    private final RestTemplate restTemplate;
//
//    @Autowired
//    public NameService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
    @Autowired
    private RestTemplate restTemplate;

    private ResponseEntity<String> response(String apiUrl) {

        return this.restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                String.class
        );
    }

    public String getUserNameByCallApi(String id) {
        // Assuming the external API returns a JSON response with a "name" field
        String apiUrl = "http://localhost:8888/api/users";
        System.out.println("id now: " + id);

        ResponseEntity<String> responseEntity = response(apiUrl);


//        String result = restTemplate.getForObject(apiUrl, String.class);
        String result = responseEntity.getBody();
        System.out.println("result: " + result);

        return result;
    }


    public String getUserName(String id) {
        return "Real user name";
    }


}