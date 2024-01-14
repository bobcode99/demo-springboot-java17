package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private NameService nameServiceMock;

    @InjectMocks
    private UserService userService;

    @Mock
    private RestTemplate restTemplateMock;

    @Test
    public void testGetUserName() {
        // Arrange
        String id = "123";
        String expectedUserName = "Mocked user name";

        // Mock the behavior of the nameServiceMock
        when(nameServiceMock.getUserName(id)).thenReturn(expectedUserName);

        // Act
        String actualUserName = userService.getUserName(id);

        // Assert
        assertEquals(expectedUserName, actualUserName);
    }

    @Test
    public void testGetUserNameOnline() {
        // Arrange
        String id = "123";
        String expectedUserName = "Mocked user name Online";

        // Mock the behavior of the restTemplateMock
        String apiUrl = "http://localhost:8888/api/users";
        when(restTemplateMock.getForObject(apiUrl, String.class)).thenReturn(expectedUserName);

        // Act
        String actualUserName = userService.getUserNameOnline(id);

        // Assert
        assertEquals(expectedUserName, actualUserName);
    }


}
