package com.sumanth.bank.ezybank.mapper;


import com.sumanth.bank.ezybank.dto.TransactionDTO;
import com.sumanth.bank.ezybank.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionDTO toDto(Transaction transaction) {
        return new TransactionDTO(transaction);
    }

}

