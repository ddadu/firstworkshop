package com.example.firstworkshop.controller;

import com.example.firstworkshop.service.UserService;
import entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getAll(Users users){
        return userService.getAll(users);
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Users> add(@RequestBody Users users){
        userService.add(users);
        var location = UriComponentsBuilder.fromPath("/users/" + users.getUserid()).build().toUri();
        return ResponseEntity.created(location).body(users);
    }
    @PutMapping("/{id}")
    public Users update(@PathVariable int id, @RequestBody Users users){
        return userService.update(id, users);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> delete(@PathVariable int id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
