package com.sumanth.bank.ezybank.service;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.sumanth.bank.ezybank.dto.UserResponse;
import com.sumanth.bank.ezybank.model.LoginRequest;
import com.sumanth.bank.ezybank.model.User;
import com.sumanth.bank.ezybank.repository.UserRepository;
import com.sumanth.bank.ezybank.util.JsonUtil;
import com.sumanth.bank.ezybank.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Override
    public ResponseEntity<String> registerUser(User user) {
        validationUtil.validateNewUser(user);
        encodePassword(user);
        val savedUser=saveUserWithAccount(user);
        return ResponseEntity.ok(JsonUtil.toJson(new UserResponse(savedUser)));
    }



    private void encodePassword(User user) {
        user.setCountryCode(user.getCountryCode().toUpperCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    private User saveUserWithAccount(User user) {
        val savedUser = saveUser(user);
        savedUser.setAccount(accountService.createAccount(savedUser));
        return saveUser(savedUser);
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
