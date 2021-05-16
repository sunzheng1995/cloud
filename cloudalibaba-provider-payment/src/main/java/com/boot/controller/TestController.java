package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    public String info;

    @GetMapping("/test")
    public String test() {
        return port;
    }

    @GetMapping("/getConfig")
    public String getConfig() {
        return info;
    }
}
