package com.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cloud.model.Payment;
import com.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentServiceImpl implements PaymentService {
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public Payment getById(long id) {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10 / 0;
        return new Payment();
    }

    public Payment timeOutHandler(long id) {
        Payment payment = new Payment();
        payment.setSerial("服务异常！");
        return payment;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "调用成功！" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable Integer id) {
        return "id不能为负数" + id;
    }
}
