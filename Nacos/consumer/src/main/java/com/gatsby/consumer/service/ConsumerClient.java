package com.gatsby.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */


@FeignClient("nacos-provider")      // nacos服务 id
public interface ConsumerClient {
    @GetMapping("/nacos/{id}")
    String call(@PathVariable("id") Integer id);
}