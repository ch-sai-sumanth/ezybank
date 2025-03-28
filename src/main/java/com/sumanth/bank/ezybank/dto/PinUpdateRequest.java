package com.sumanth.bank.ezybank.dto;

public record PinUpdateRequest(String accountNumber, String oldPin, String newPin, String password) {
}
