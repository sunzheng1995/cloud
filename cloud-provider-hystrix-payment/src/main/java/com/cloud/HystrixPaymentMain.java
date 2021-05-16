package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class HystrixPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain.class, args);
    }
}
