package com.cloud.controller;

import com.cloud.model.CommonResult;
import com.cloud.model.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert success:{}", result);
        return new CommonResult(200, "插入成功！");
    }

    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable long id) {
        Payment payment = paymentService.getById(id);
        return new CommonResult<>(200, "请求成功！端口 " + port, payment);
    }
}
