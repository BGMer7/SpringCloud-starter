package com.gatsby.consumer.controller;

import com.gatsby.consumer.service.ConsumerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */


@Slf4j
@RestController
@RequestMapping("/feign")
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
        return consumerClient.sayHello();
    }

    @GetMapping("/get-id/{id}")
    public String getId(@PathVariable("id") Integer id) {
        return "FeignClient gets message from: " + consumerClient.getId(id);
    }

}