package com.sumanth.bank.ezybank.controller;

import com.sumanth.bank.ezybank.service.DashboardService;
import com.sumanth.bank.ezybank.util.JsonUtil;
import com.sumanth.bank.ezybank.util.LoggedinUser;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/user")
    public ResponseEntity<String> getUserDetails() {
        val accountNumber = LoggedinUser.getAccountNumber();
        val userResponse = dashboardService.getUserDetails(accountNumber);
        return ResponseEntity.ok(JsonUtil.toJson(userResponse));
    }

    @GetMapping("/account")
    public ResponseEntity<String> getAccountDetails() {
        val accountNumber = LoggedinUser.getAccountNumber();
        val accountResponse = dashboardService.getAccountDetails(accountNumber);
        return ResponseEntity.ok(JsonUtil.toJson(accountResponse));
    }

}
