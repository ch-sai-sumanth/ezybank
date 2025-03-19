package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.OtpRequest;
import com.sumanth.bank.ezybank.dto.OtpVerificationRequest;
import com.sumanth.bank.ezybank.exception.InvalidTokenException;
import com.sumanth.bank.ezybank.model.LoginRequest;
import com.sumanth.bank.ezybank.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public interface UserService {

    public ResponseEntity<String> registerUser(User user);
    public User saveUser(User user);
    public ResponseEntity<String> login(LoginRequest loginRequest, HttpServletRequest request) throws InvalidTokenException;
    public User getUserByIdentifier(String identifier);
    public User getUserByEmail(String email);

    public User getUserByAccountNumber(String accountNumber);
    public ResponseEntity<String>generateOtp(OtpRequest otpRequest);

    ResponseEntity<String> verifyOtpAndLogin(OtpVerificationRequest otpVerificationRequest) throws InvalidTokenException;
}
