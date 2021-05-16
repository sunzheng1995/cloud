package com.cloud.service;

import com.cloud.model.CommonResult;
import com.cloud.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(long id) {
        Payment payment = new Payment();
        payment.setSerial("fallback");
        return new CommonResult<>(500, "请求失败了！", payment);
    }
}
