package com.sumanth.bank.ezybank.service;



import com.sumanth.bank.ezybank.dto.OtpRequest;
import com.sumanth.bank.ezybank.dto.OtpVerificationRequest;
import com.sumanth.bank.ezybank.dto.ResetPasswordRequest;
import com.sumanth.bank.ezybank.model.User;
import org.springframework.http.ResponseEntity;



public interface AuthService {
    public String generatePasswordResetToken(User user);

    public boolean verifyPasswordResetToken(String token, User user);

    public void deletePasswordResetToken(String token);

    public ResponseEntity<String> sendOtpForPasswordReset(OtpRequest otpRequest);

    public ResponseEntity<String> verifyOtpAndIssueResetToken(OtpVerificationRequest otpVerificationRequest);

    public ResponseEntity<String> resetPassword(ResetPasswordRequest resetPasswordRequest);

}

