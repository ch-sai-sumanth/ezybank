package com.sumanth.bank.ezybank.repository;

import com.sumanth.bank.ezybank.model.OtpInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpInfoRepository extends JpaRepository<OtpInfo,Long> {

    OtpInfo findByAccountNumberAndOtp(String accountNumber, String otp);

    OtpInfo findByAccountNumber(String accountNumber);

}
