package com.cloud.controller;

import com.cloud.model.CommonResult;
import com.cloud.model.Payment;
import com.cloud.service.PaymentFeignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@DefaultProperties(defaultFallback = "commonTimeOutHandler")
@RequestMapping("/consumer")
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
//    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
//    @HystrixCommand
    public CommonResult<Payment> getPaymentById(@PathVariable long id) {
        return paymentFeignService.getPaymentById(id);
    }

//    public CommonResult<Payment> timeOutHandler(long id) {
//        return new CommonResult<>(500, "服务异常！", new Payment());
//    }

    public CommonResult<Payment> commonTimeOutHandler() {
        return new CommonResult<>(500, "服务异常！", new Payment());
    }
}
