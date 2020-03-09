package com.example.demo5;

import com.example.demo5.service.UserService;
import com.example.demo5.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {


    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void create(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        User userByID = userService.getById(id);
        return ResponseEntity.ok(userByID);
    }

    @PutMapping(value = "/user/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        userService.updateUserById(id, user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
