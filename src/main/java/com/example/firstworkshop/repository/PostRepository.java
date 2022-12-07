package com.example.firstworkshop.repository;

import entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository <Posts, Integer>{


    List<Posts> findUserId(int id);
}
