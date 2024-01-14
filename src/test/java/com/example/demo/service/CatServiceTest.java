package com.example.demo.service;

import com.example.demo.vo.Cat;
import com.example.demo.vo.CatData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatServiceTest {

    @InjectMocks
    private CatService catService;
    @Mock
    private RestTemplate restTemplate;

    @Test
    void getSumOfCatWeights1() {
        // Mock the response from the external API
        CatData mockCatData = new CatData();
//        mockCatData.setCatsData(Collections.singletonList(new Cat("Bob", 23)));
        mockCatData.setCatsData(List.of(new Cat("Bob", 23), new Cat("Amao", 30)));
//        // Set up the mock
//        when(restTemplate.getForObject("http://localhost:8888/api/cats", CatData.class))
//                .thenReturn(mockCatData);


        // Set up the mock for RestTemplate.exchange
        ResponseEntity<CatData> responseEntity = ResponseEntity.ok(mockCatData);
        when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<CatData>>any()
        )).thenReturn(responseEntity);

        // Test the service method
        int sumOfWeights = catService.getSumOfCatWeights();

        // Verify the expected behavior
        assertEquals(53, sumOfWeights);
    }
}

