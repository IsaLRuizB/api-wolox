package com.prueba.api.wolox.controller;

import com.prueba.api.wolox.client.CommentsClient;
import com.prueba.api.wolox.client.AlbumsClient;
import com.prueba.api.wolox.client.PhotosClient;
import com.prueba.api.wolox.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    UserClient userClient;

    @Autowired
    PhotosClient photosClient;

    @Autowired
    AlbumsClient albumsClient;

    @Autowired
    CommentsClient commentsClient;

    @GetMapping("/users")
    public ResponseEntity<?> buscarUsuarios(){
        return ResponseEntity.ok(userClient.getUsers());
    }

    @GetMapping("/photos")
    public ResponseEntity<?> buscarPhotos(){
        return ResponseEntity.ok(photosClient.getPhotos());
    }

    @GetMapping("/albums")
    public ResponseEntity<?> buscarAlbumes(){
        return ResponseEntity.ok(albumsClient.getAlbums());
    }
    @GetMapping("/comments")
    public ResponseEntity<?> buscarComments(){
        return ResponseEntity.ok(commentsClient.getComments());
    }
}
