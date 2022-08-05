package com.boyo.blog.controller;

import com.boyo.blog.data.models.User;
import com.boyo.blog.dtos.requests.RegisterUserRequest;
import com.boyo.blog.dtos.requests.UpdateUserRequest;
import com.boyo.blog.dtos.responses.RegisterUserResponse;
import com.boyo.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public RegisterUserResponse registerUSer(@RequestBody RegisterUserRequest request) {
        return userService.saveUser(request);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }



    @PatchMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest request) {
        try {
            return new ResponseEntity<>(userService.updateUser(request), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(err.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(err.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
