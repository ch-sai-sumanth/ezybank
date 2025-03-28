package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);

}
