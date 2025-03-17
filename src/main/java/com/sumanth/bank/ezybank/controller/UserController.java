package com.sumanth.bank.ezybank.controller;


import com.sumanth.bank.ezybank.model.LoginRequest;
import com.sumanth.bank.ezybank.model.User;
import com.sumanth.bank.ezybank.service.UserService;
import com.sumanth.bank.ezybank.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
