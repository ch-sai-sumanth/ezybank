package com.sumanth.bank.ezybank.dto;

public record ResetPasswordRequest(String identifier, String resetToken, String newPassword) {
}
