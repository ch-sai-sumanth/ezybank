package com.sumanth.bank.ezybank.exception;

public class OtpRetryLimitExceededException extends RuntimeException {
    public OtpRetryLimitExceededException(String message) {
        super(message);
    }
}
