package com.prueba.api.wolox.client;


import com.prueba.dominio.dominiodto.dto.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CommentsClient {

    @Autowired
    public RestTemplate restTemplate;

    public static  String url="https://jsonplaceholder.typicode.com/comments";

    void CommentsClient(){
        this.url=url;
    }

    public Comments[] getComments (){
        restTemplate= new RestTemplate();
        ResponseEntity<Comments[]> response = restTemplate.getForEntity(url, Comments[].class);
        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : null;
        }

        public static void main(String[] args) {
            CommentsClient  commentsClient = new CommentsClient();
            System.out.println("Calling GET for entity using arrays " + commentsClient.getComments());


        }

}
