package org.example.springrestclient.service;

import org.example.springrestclient.dto.UserDataDto;
import org.example.springrestclient.dto.UserDto;
import org.example.springrestclient.model.UserData;
import org.example.springrestclient.model.UserModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class UserService {

    private final RestClient restClient;

    public UserService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://reqres.in/api")
                .defaultHeader("x-api-key", "reqres-free-v1")
                .build();
    }

    // get all users
    public List<UserModel> getAllUsers() {
        List<UserModel> users =
                restClient.get()
                        .uri("/users")
                        .retrieve()
                        .body(UserData.class)
                        .data();
        return users;
    }

    // create a user
    public UserDataDto createUser(UserDto newUser) {
        return restClient.post()
                .uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newUser)
                .retrieve()
                .body(UserDataDto.class);
    }

}
