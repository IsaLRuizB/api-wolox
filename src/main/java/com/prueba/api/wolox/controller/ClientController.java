package com.prueba.api.wolox.controller;

import com.prueba.api.wolox.client.*;
import com.prueba.api.wolox.dto.*;
import com.prueba.api.wolox.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    PostClient postClient;

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
    @GetMapping("/photos/{idUser}")
    public ResponseEntity<?> buscarPhotosPorUsuario(@PathVariable Long idUser){
        List<Album> listAlbums = Arrays.asList(albumsClient.getAlbums());
        //se obtienen los ids de los albumes
        List<Long> listIdAlbumes= listAlbums
                .stream()
                .filter(album -> album.getUserId() == idUser)
                .map(album -> album.getId())
                .collect(Collectors.toList());

        //se obtienen las photos
        List<Photos> listPhotos = Arrays.asList(photosClient.getPhotos());
        //se filtran las photos por el id del album
        List<Photos> listResultPhotos = (List<Photos>) listPhotos
                .stream()
                .filter(photo -> listIdAlbumes.stream().anyMatch(idAlbum -> photo.getAlbumId().equals(idAlbum)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listResultPhotos);
    }

    @GetMapping("/comments/{name}")
    public ResponseEntity<?> buscarComentPorName(@PathVariable String name){
        List<Comments> listComments = Arrays.asList(commentsClient.getComments());
        Comments result = new Comments();
        //se obtiene el comentario
        for(Comments comment:listComments ){
            if( comment.getName().equals(name)){
                result = mapper.map(comment,Comments.class);
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/commentsByUser/{idUser}")
    public ResponseEntity<?> buscarComentPorUsuario(@PathVariable Long idUser){
        List<Post> listPost = Arrays.asList(postClient.getPost());
        //se obtienen los ids de los post
        List<Long> listIdPost= listPost
                .stream()
                .filter(post -> post.getUserId() == idUser)
                .map(post -> post.getId())
                .collect(Collectors.toList());

        //se obtienen los comentarios
        List<Comments> listComments = Arrays.asList(commentsClient.getComments());
        //se filtran los comenatrios por el id del post
        List<Comments> listResulComments = (List<Comments>) listComments
                .stream()
                .filter(comment -> listIdPost.stream().anyMatch(idPost -> comment.getPostId().equals(idPost)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listResulComments);
    }

    
}
