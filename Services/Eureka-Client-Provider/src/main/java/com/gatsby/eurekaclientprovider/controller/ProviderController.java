package com.gatsby.eurekaclientprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author -- gatsby
 * @date -- 2022/4/23
 * @description -- Eureka Client Provider控制器
 */


@RestController
@RequestMapping(value = "/provider")
public class ProviderController {
    @Value("${server.port}")
    String port;

    @GetMapping(value = "/port")
    public String getPort() {
        return "Eureka Client Provider is running on port - " + port + ".";
    }
}