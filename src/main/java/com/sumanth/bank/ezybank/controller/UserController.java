package com.sumanth.bank.ezybank.controller;


import com.sumanth.bank.ezybank.dto.OtpRequest;
import com.sumanth.bank.ezybank.dto.OtpVerificationRequest;
import com.sumanth.bank.ezybank.exception.InvalidTokenException;
import com.sumanth.bank.ezybank.model.LoginRequest;
import com.sumanth.bank.ezybank.model.User;
import com.sumanth.bank.ezybank.service.UserService;
import com.sumanth.bank.ezybank.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) throws InvalidTokenException {
        return userService.login(loginRequest, request);
    }

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestBody OtpRequest otpRequest) {
        return userService.generateOtp(otpRequest);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtpAndLogin(@RequestBody OtpVerificationRequest otpVerificationRequest)
            throws InvalidTokenException {

        return userService.verifyOtpAndLogin(otpVerificationRequest);
    }
}
