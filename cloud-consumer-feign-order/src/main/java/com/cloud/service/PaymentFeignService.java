package com.cloud.service;

import com.cloud.model.CommonResult;
import com.cloud.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") long id);

}
