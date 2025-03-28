package com.sumanth.bank.ezybank.service;


import java.util.List;
import java.util.stream.Collectors;

import com.sumanth.bank.ezybank.dto.TransactionDTO;
import com.sumanth.bank.ezybank.mapper.TransactionMapper;
import com.sumanth.bank.ezybank.repository.TransactionRepository;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber) {
        val transactions = transactionRepository
                .findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(accountNumber, accountNumber);

        val transactionDTOs = transactions.parallelStream()
                .map(transactionMapper::toDto)
                .sorted((t1, t2) -> t2.getTransactionDate().compareTo(t1.getTransactionDate()))
                .collect(Collectors.toList());

        return transactionDTOs;
    }

}

