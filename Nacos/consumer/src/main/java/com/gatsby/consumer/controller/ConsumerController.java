package com.gatsby.consumer.controller;

import com.gatsby.consumer.service.ConsumerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */


@RestController
@Slf4j
public class ConsumerController {
    @Resource
    private ConsumerClient consumer;      // 加载 openfeign client

    @GetMapping("/consumer")
    public String consumer(@RequestParam Integer id) {
        log.info(String.valueOf(id));
        // 向调用本地方法一样，调用 openfeign client 中的方法
        return consumer.call(id);
    }
}