package com.example.firstworkshop.controller;

import com.example.firstworkshop.service.PostService;
import entity.Posts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping()
    public List<Posts> getAll(Posts posts){
        return postService.getAll(posts);
    }
    @GetMapping("/{id}")
    public Posts getPostById (@PathVariable int id){
        return postService.getPostById(id);
    }
    @PostMapping()
    public ResponseEntity<Posts> add(@RequestBody Posts posts){
        postService.add(posts);
        var location = UriComponentsBuilder.fromPath("/posts/" + posts.getPostId()).build().toUri();
        return ResponseEntity.created(location).body(posts);
    }
    @PutMapping("/{id}")
    public Posts update(@PathVariable int id, @RequestBody Posts posts){
        return postService.update(id, posts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Posts> delete(@PathVariable int id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
