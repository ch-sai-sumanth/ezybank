package com.sumanth.bank.ezybank.util;


import com.sumanth.bank.ezybank.exception.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


import lombok.val;

public class LoggedinUser {

    public static String getAccountNumber() {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new NotFoundException("No user is currently logged in.");
        }
        val principal = (User) authentication.getPrincipal();
        return principal.getUsername();
    }

}
