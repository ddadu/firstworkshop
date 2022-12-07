package com.example.firstworkshop.service;

import com.example.firstworkshop.exception.NotFoundException;
import com.example.firstworkshop.repository.UserRepository;
import entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<Users> getAll(Users users) {
        return userRepository.findAll();
    }

    public Users getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException ("User not Found"));
    }

    public Users add(Users users){
        users.setUserid(null);
        users.setActive(true);
        return userRepository.save(users);
    }

    public Users update(int id, Users users) {
        var foundUser = getUserById(id);
        foundUser.setUsername(users.getUsername());
        foundUser.setPassword(users.getPassword());
        foundUser.setEmail(users.getEmail());
        userRepository.save(foundUser);
        return foundUser;
    }


      public void delete(int id){
          var foundUser = getUserById(id);
          foundUser.setActive(false);
          userRepository.save(foundUser);

    }

}
