package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 */
@MapperScan("com.cloud.dao")
@EnableTransactionManagement
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
    }
}
