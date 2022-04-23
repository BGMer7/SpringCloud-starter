package com.example.feignprovider.controller;

import com.example.feignprovider.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author -- gatsby
 * @date -- 2022/4/23
 * @description -- Port Controller
 */

@RestController
@RequestMapping(value = "/feign-provider")
public class PortController {
    PortService portService;

    @Autowired
    PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping(value = "/port")
    public String getPort() {
        return portService.getPort();
    }
}