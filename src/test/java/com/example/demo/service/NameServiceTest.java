package com.example.demo.service;

import com.example.demo.vo.CatData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NameServiceTest {
    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private NameService nameService;

    @Test
    public void testGetUserNameOnline() {
        // Arrange
        String id = "123";
        String expectedUserName = "Mocked user name";

        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the behavior of the restTemplateMock
        String apiUrl = "http://localhost:8888/api/users";
//        when(restTemplateMock.getForObject(apiUrl, String.class)).thenReturn(expectedUserName);

        ResponseEntity<String> responseEntity = ResponseEntity.ok(expectedUserName);
        when(restTemplateMock.exchange(
                ArgumentMatchers.eq(apiUrl),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String >>any()
        )).thenReturn(responseEntity);

        // Act
        String actualUserName = nameService.getUserNameByCallApi(id);

        // Assert
        assertEquals(expectedUserName, actualUserName);
    }
}
