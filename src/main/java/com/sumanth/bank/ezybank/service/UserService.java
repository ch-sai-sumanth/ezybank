package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.model.LoginRequest;
import com.sumanth.bank.ezybank.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<String> registerUser(User user);
    public User saveUser(User user);
}
