package com.sumanth.bank.ezybank.repository;

import com.sumanth.bank.ezybank.model.Account;
import com.sumanth.bank.ezybank.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findByToken(String token);

    Token[] findAllByAccount(Account account);

    void deleteByToken(String token);
}
