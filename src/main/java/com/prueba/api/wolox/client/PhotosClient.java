package com.prueba.api.wolox.client;

import com.prueba.api.wolox.dto.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PhotosClient {

    @Autowired
    public RestTemplate restTemplate;
    public static  String url="https://jsonplaceholder.typicode.com/photos";

    void PhotosClient(){
        this.url=url;
    }

    public Photos[] getPhotos (){
        restTemplate= new RestTemplate();
        ResponseEntity<Photos[]> response = restTemplate.getForEntity(url, Photos[].class);
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }



}
