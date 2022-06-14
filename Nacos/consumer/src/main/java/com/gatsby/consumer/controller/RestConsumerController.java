package com.gatsby.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */

@Slf4j
@RestController(value = "/consumer")
public class RestConsumerController {
    // 注入RestTemplate
    private final RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @Autowired
    public RestConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/sayHello")
    public String sayHello() {
        log.info("Hello from consumer");
        // RestTemplate调用的时候直接使用服务名+方法名，这样就屏蔽掉了
        return "Hello from consumer, and provider says: " +
                restTemplate.getForObject("http://nacos-provider/sayHello", String.class);
    }

    // 在消费者这里采用的是get方法，但是去请求提供生产者是使用的post方法
    @GetMapping(value = "/get-id/{id}")
    public String getId(@PathVariable("id") Integer id) {
        log.info(String.valueOf(id));
        // RestTemplate的传参需要MultiValueMap数据结构
        MultiValueMap<String, Integer> param = new LinkedMultiValueMap<>();
        param.add("id", id);
        return "<h2>访问成功！</h2>服务名：nacos-consumer<br/> 端口号：" +
                port + "<br/> 传入的参数：" + id +
                restTemplate.postForObject("http://nacos-provider/get-id", param, String.class);
    }
}