package com.gatsby.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */


@FeignClient("nacos-provider")      // nacos服务 id
public interface ConsumerClient {
    @GetMapping("/provider/sayHello")
    String sayHello();

    @PostMapping("/provider/get-id")
    String getId(@RequestParam Integer id);
}