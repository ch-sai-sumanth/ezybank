package com.sumanth.bank.ezybank.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sumanth.bank.ezybank.exception.AccountDoesNotExistException;
import com.sumanth.bank.ezybank.exception.FundTransferException;
import com.sumanth.bank.ezybank.exception.GeolocationException;
import com.sumanth.bank.ezybank.exception.InsufficientBalanceException;
import com.sumanth.bank.ezybank.exception.InvalidAmountException;
import com.sumanth.bank.ezybank.exception.InvalidTokenException;
import com.sumanth.bank.ezybank.exception.InvalidOtpException;
import com.sumanth.bank.ezybank.exception.InvalidPinException;
import com.sumanth.bank.ezybank.exception.NotFoundException;
import com.sumanth.bank.ezybank.exception.OtpRetryLimitExceededException;
import com.sumanth.bank.ezybank.exception.PasswordResetException;
import com.sumanth.bank.ezybank.exception.UnauthorizedException;
import com.sumanth.bank.ezybank.exception.UserInvalidException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountDoesNotExistException.class)
    public ResponseEntity<String> handleAccountDoesNotExistException(
            AccountDoesNotExistException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(FundTransferException.class)
    public ResponseEntity<String> handleFundTransferException(FundTransferException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(GeolocationException.class)
    public ResponseEntity<String> handleGeolocationException(GeolocationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(
            InsufficientBalanceException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<String> handleInvalidAmountException(InvalidAmountException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidOtpException.class)
    public ResponseEntity<String> handleInvalidOtpException(InvalidOtpException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPinException.class)
    public ResponseEntity<String> handleInvalidPinException(InvalidPinException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<String> handleInvalidTokenException(InvalidTokenException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handleJsonProcessingException(JsonProcessingException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(OtpRetryLimitExceededException.class)
    public ResponseEntity<String> handleOtpRetryLimitExceededException(
            OtpRetryLimitExceededException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(PasswordResetException.class)
    public ResponseEntity<String> handlePasswordResetException(PasswordResetException ex, WebRequest request) {
        return ResponseEntity.internalServerError()
                .body("{\"message\": \"" + ex.getMessage() + "\"}");
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientException(RestClientException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(UserInvalidException.class)
    public ResponseEntity<String> handleUserInvalidException(UserInvalidException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError()
                .body("{\"message\": \"An unexpected error occurred: " + ex.getMessage() + "\"}");
    }
}
