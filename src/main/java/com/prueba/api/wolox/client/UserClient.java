package com.prueba.api.wolox.client;


import com.prueba.api.wolox.dto.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserClient {

    @Autowired
    public RestTemplate restTemplate;


    public static  String url="https://jsonplaceholder.typicode.com/users";

    public UserClient( ){
        this.url=url;
    }

    public List<User> getUsers(){

        ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});

        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;

    }

    public static void main(String[] args) {
        UserClient userClient = new UserClient();
        System.out.println("Calling GET for entity using arrays " + userClient.getUsers());


    }
}
