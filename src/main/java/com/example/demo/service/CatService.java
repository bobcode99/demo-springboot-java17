package com.example.demo.service;

import com.example.demo.vo.Cat;
import com.example.demo.vo.CatData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatService {
    private final String externalApiUrl = "http://localhost:8888/api/cats";

    private final RestTemplate restTemplate;

    @Autowired
    public CatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int getSumOfCatWeights() {

        System.out.println("call getSumOfCatWeights");
        // Call the external API to get cat data
        CatData catData = fetchCatData();

        // Calculate the sum of cat weights
        int sumOfWeights = calculateSumOfWeights(catData);

        System.out.println("sumOfWeights: " + sumOfWeights);
        return sumOfWeights;
    }

//    public CatData fetchCatData() {
//        return restTemplate.getForObject(externalApiUrl, CatData.class);
//    }

    private CatData fetchCatData() {

        System.out.println("call fetchCatData: " + externalApiUrl);
        ResponseEntity<CatData> responseEntity = restTemplate.exchange(
                externalApiUrl,
                HttpMethod.GET,
                null,
                CatData.class
        );

//        System.out.println("responseEntity.getBody().getCatsData()" + responseEntity.getBody().getCatsData().get(0).getName());
        return responseEntity.getBody();
    }

    private int calculateSumOfWeights(CatData catData) {

        System.out.println("calculateSumOfWeights");
        System.out.println(catData.getCatsData() != null);
        int sum = 0;
        if (catData != null && catData.getCatsData() != null) {
            for (Cat cat : catData.getCatsData()) {
                System.out.println("name: " + cat.getName());

                System.out.println("weight: " + cat.getWeight());
                sum += cat.getWeight();
            }
        }
        return sum;
    }

}
