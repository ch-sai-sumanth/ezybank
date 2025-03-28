package com.sumanth.bank.ezybank.dto;

public record FundTransferRequest(String sourceAccountNumber, String targetAccountNumber, double amount, String pin) {
}
