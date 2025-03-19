package com.sumanth.bank.ezybank.service;

import java.util.concurrent.CompletableFuture;

public interface OtpService {

    String generateOtp(String accountNumber);

    public CompletableFuture<Void> sendOTPByEmail(String email,String name,String accountNumber, String otp) ;
    public boolean validateOTP(String accountNumber, String otp);
}
