package com.prueba.api.wolox.client;

import com.prueba.api.wolox.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class AlbumsClient {

    @Autowired
    public RestTemplate restTemplate;
    public static  String url="https://jsonplaceholder.typicode.com/albums";

    void AlbumsClient(){
        this.url= url;
    }


    public Album[]  getAlbums(){
        ResponseEntity<Album[]> response = restTemplate.getForEntity(url, Album[].class);
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

    public static void main(String[] args) {
        AlbumsClient albumClient = new AlbumsClient();
        System.out.println("Calling GET for entity using arrays " + Arrays.stream(albumClient.getAlbums()).findFirst());


    }




}
