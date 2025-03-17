package com.sumanth.bank.ezybank.repository;

import com.sumanth.bank.ezybank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    public Account findByAccountNumber(String accountNumber);
}
