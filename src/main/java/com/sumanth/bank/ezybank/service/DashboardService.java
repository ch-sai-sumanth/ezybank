package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.AccountResponse;
import com.sumanth.bank.ezybank.dto.UserResponse;

public interface DashboardService {
    UserResponse getUserDetails(String accountNumber);
    AccountResponse getAccountDetails(String accountNumber);
}
