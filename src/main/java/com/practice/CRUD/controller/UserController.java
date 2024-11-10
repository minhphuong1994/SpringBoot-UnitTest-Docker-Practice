package com.practice.CRUD.controller;

import com.practice.CRUD.model.User;
import com.practice.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public void testing(){
        userService.test();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("/deleteById")
    public User deleteUserById(@RequestParam Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
