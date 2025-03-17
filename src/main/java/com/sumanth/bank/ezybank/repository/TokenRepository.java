package com.sumanth.bank.ezybank.repository;

import com.sumanth.bank.ezybank.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
}
