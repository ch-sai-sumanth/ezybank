package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.GeolocationResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface GeolocationService {
    @Async
    public CompletableFuture<GeolocationResponse> getGeolocation(String ip);
}
