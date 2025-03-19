package com.sumanth.bank.ezybank.service;

import com.sumanth.bank.ezybank.dto.GeolocationResponse;
import com.sumanth.bank.ezybank.exception.GeolocationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeolocationServiceImpl implements GeolocationService {
    @Value("${geo.api.url}")
    private String apiUrl;

    @Value("${geo.api.key}")
    private String apiKey;

    @Override
    @Async
    public CompletableFuture<GeolocationResponse> getGeolocation(String ip) {
        val future = new CompletableFuture<GeolocationResponse>();

        try {
            // Validate IP address
            InetAddress.getByName(ip);

            log.info("Getting geolocation for IP: {}", ip);

            // Call geolocation API
            val url = String.format("%s/%s/?token=%s", apiUrl, ip, apiKey);
            val response = new RestTemplate()
                    .getForObject(url, GeolocationResponse.class);

            if (response == null) {
                log.error("Failed to get geolocation for IP: {}", ip);
                future.completeExceptionally(new GeolocationException(
                        "Failed to get geolocation for IP: " + ip));
            } else {
                future.complete(response);
            }

        } catch (UnknownHostException e) {
            log.error("Invalid IP address: {}", ip, e);
            future.completeExceptionally(e);

        } catch (RestClientException e) {
            log.error("Failed to get geolocation for IP: {}", ip, e);
            future.completeExceptionally(e);
        }

        return future;
    }
}
