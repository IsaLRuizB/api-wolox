package com.prueba.api.wolox.client;

import com.prueba.api.wolox.dto.Photos;
import com.prueba.api.wolox.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PostClient {

    @Autowired
    public RestTemplate restTemplate;

    public  static  String url="https://jsonplaceholder.typicode.com/posts";
    public  PostClient(){this.url=url;}

    public Post[] getPost(){
        ResponseEntity<Post[]> response = restTemplate.getForEntity(url, Post[].class);
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
    }

}
