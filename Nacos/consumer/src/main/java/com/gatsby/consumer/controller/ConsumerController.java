package com.gatsby.consumer.controller;

import com.gatsby.consumer.service.ConsumerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */


@Slf4j
@RestController(value = "/feign")
public class ConsumerController {
    @Resource
    private final ConsumerClient consumerClient;      // 加载 openfeign client

    public ConsumerController(ConsumerClient consumerClient) {
        this.consumerClient = consumerClient;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("Consumer Feign Hello");
        // 调用Feign方法，类RPC
        return consumerClient.call();
    }
}