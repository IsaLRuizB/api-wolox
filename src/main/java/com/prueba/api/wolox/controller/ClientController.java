package com.prueba.api.wolox.controller;

import com.prueba.api.wolox.client.CommentsClient;
import com.prueba.api.wolox.client.AlbumsClient;
import com.prueba.api.wolox.client.PhotosClient;
import com.prueba.api.wolox.client.UserClient;
import com.prueba.api.wolox.dto.User;
import com.prueba.api.wolox.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> buscarUsuarios(){
        List<User> listUsers =userClient.getUsers();
        for(User user: listUsers){

            com.prueba.api.wolox.models.entity.User entity= mapper.map(user,com.prueba.api.wolox.models.entity.User.class );
            if (!userService.existsById(entity.getId())){
                userService.save(entity);
            }
            System.out.println(entity.getAddress().getGeo().getLng());
        }
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
