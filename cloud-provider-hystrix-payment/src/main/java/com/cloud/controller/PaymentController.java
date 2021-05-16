package com.cloud.controller;

import com.cloud.model.CommonResult;
import com.cloud.model.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable long id) {
        Payment result = paymentService.getById(id);
        return new CommonResult<>(200, "请求成功！", result);
    }
}
