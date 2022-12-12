package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.services.MovieService;
import com.example.BNTA_Backend_Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<User>> getUserById(@PathVariable Long id){
        return null;
    }

    //TODO check whether we need "List<User>"
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        return null;
    }

}
