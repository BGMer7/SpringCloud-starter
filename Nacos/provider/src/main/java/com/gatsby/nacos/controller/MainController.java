package com.gatsby.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author -- gatsby
 * @date -- 2022/6/13
 * @description --
 */
@Slf4j
@RestController(value = "/provider")
public class MainController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/sayHello")
    public String sayHello() {
        log.info("Hello from provider");
        return "Hello from provider";
    }

    @PostMapping(value = "/get-id")
    public String getId(@RequestParam Integer id) {
        log.info(String.valueOf(id));
        return "<h2>访问成功！</h2>服务名：nacos-provider<br/> 端口号：" + serverPort + "<br/> 传入的参数：" + id;
    }
}