package com.iuliana.controller;

import com.iuliana.model.User;
import com.iuliana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/delete-user/{id}", produces = "application/json")
    public User deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @PatchMapping(value = "/update-user", produces = "application/json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping(value = "/add-user", produces = "application/json")
    public User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @GetMapping(value = "/find-by-first-name", produces = "application/json")
    public Set<User> findByFirstName(@RequestParam String firstName){
        return userService.findByFirstName(firstName);
    }
}
