package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.cloud.dao")
@EnableEurekaClient
@SpringBootApplication
public class PaymentBackMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentBackMain.class, args);
    }
}
