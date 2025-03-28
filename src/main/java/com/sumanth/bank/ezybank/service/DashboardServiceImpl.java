package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.AccountResponse;
import com.sumanth.bank.ezybank.dto.UserResponse;
import com.sumanth.bank.ezybank.exception.NotFoundException;
import com.sumanth.bank.ezybank.repository.AccountRepository;
import com.sumanth.bank.ezybank.repository.UserRepository;
import com.sumanth.bank.ezybank.util.ApiMessages;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public UserResponse getUserDetails(String accountNumber) {
        val user = userRepository.findByAccount_AccountNumber(accountNumber)
                .orElseThrow(() -> new NotFoundException(
                        String.format(ApiMessages.USER_NOT_FOUND_BY_ACCOUNT.getMessage(), accountNumber)));

        return new UserResponse(user);
    }

    @Override
    public AccountResponse getAccountDetails(String accountNumber) {
        val account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NotFoundException(String.format(ApiMessages.USER_NOT_FOUND_BY_ACCOUNT.getMessage(), accountNumber));
        }

        return new AccountResponse(account);
    }

}
