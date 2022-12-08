package com.example.firstworkshop.service;

import com.example.firstworkshop.exception.NotFoundException;
import com.example.firstworkshop.repository.PostRepository;
import entity.Posts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService (PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Posts> getAll(Posts posts){
        return postRepository.findAll();
    }
    public Posts getPostById(int id){
        return postRepository.findById(id).orElseThrow(
                () -> new NotFoundException ("Post not found"));
    }
    public Posts add(Posts posts){
        posts.setPostId(null);
        posts.setDelete(false);
        return postRepository.save(posts);

    }
    public Posts update(int id, Posts posts){
        var foundPost = getPostById(id);
        foundPost.setTitle(posts.getTitle());
        foundPost.setBody(posts.getBody());
        postRepository.save(foundPost);
        return foundPost;
    }
    public List<Posts> getUserId(int id){
        return postRepository.findUserId(id);
    }
    public void delete(int id){
        var foundUser = getPostById(id);
        foundUser.setDelete(true);
        postRepository.save(foundUser);
    }


}
