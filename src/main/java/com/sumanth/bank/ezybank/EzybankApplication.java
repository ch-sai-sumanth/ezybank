package com.sumanth.bank.ezybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EzybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzybankApplication.class, args);
	}

}
