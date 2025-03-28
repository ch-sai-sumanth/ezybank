package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.model.Account;
import com.sumanth.bank.ezybank.model.User;

public interface AccountService {
    public Account createAccount(User user);
    public boolean isPinCreated(String accountNumber) ;
    public void createPin(String accountNumber, String password, String pin) ;
    public void updatePin(String accountNumber, String oldPIN, String password, String newPIN);
    public void cashDeposit(String accountNumber, String pin, double amount);
    public void cashWithdrawal(String accountNumber, String pin, double amount);
    public void fundTransfer(String sourceAccountNumber, String targetAccountNumber, String pin, double amount);

}
