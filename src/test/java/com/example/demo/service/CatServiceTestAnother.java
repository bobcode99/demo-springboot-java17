package com.example.demo.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.demo.service.CatService;
import com.example.demo.vo.Cat;
import com.example.demo.vo.CatData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CatServiceTestAnother {

    @Mock
    private RestTemplate restTemplate;

    private CatService catService;

    @BeforeEach
    public void setUp() {
        catService = spy(new CatService(restTemplate));
    }

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        catService = new CatService(restTemplate);
//    }

    @Test
    public void testGetSumOfCatWeights() {
        // Arrange
        CatData mockCatData = new CatData();
        Cat cat1 = new Cat("Fluffy", 5);
        Cat cat2 = new Cat("Whiskers", 8);

        mockCatData.setCatsData(List.of(cat1, cat2));

        ResponseEntity<CatData> mockResponseEntity = new ResponseEntity<>(mockCatData, HttpStatus.OK);

//        when(restTemplate.exchange(
//                eq("http://localhost:8888/api/cats"),
//                eq(HttpMethod.GET),
//                eq(null),
//                eq(CatData.class)
//        )).thenReturn(mockResponseEntity);
        // Spy the catService
        when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<CatData>>any()
        )).thenReturn(mockResponseEntity);
        // Add debugging output
        System.out.println("Mock Response: " + mockResponseEntity.getBody().getCatsData().get(0).getName());
        System.out.println("Mock Response: " + mockResponseEntity.getBody().getCatsData().get(0).getName());
        // Act
        int sumOfWeights = catService.getSumOfCatWeights();

        // Assert
        assertEquals(13, sumOfWeights); // 5 (Fluffy) + 8 (Whiskers)
    }

    @Test
    public void testGetSumOfCatWeightsNoData() {
        // Arrange
        CatData mockCatData = new CatData(); // Empty CatData

        ResponseEntity<CatData> mockResponseEntity = new ResponseEntity<>(mockCatData, HttpStatus.OK);

        when(restTemplate.exchange(
                eq("http://localhost:8888/api/cats"),
                eq(HttpMethod.GET),
                eq(null),
                eq(CatData.class)
        )).thenReturn(mockResponseEntity);

        // Act
        int sumOfWeights = catService.getSumOfCatWeights();

        // Assert
        assertEquals(0, sumOfWeights); // No cats, so the sum should be 0
    }
}
