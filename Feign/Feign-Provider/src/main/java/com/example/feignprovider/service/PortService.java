package com.example.feignprovider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author -- gatsby
 * @date -- 2022/4/23
 * @description -- Port Service
 */


@Component
@FeignClient(value = "eureka-client-provider")
public interface PortService {
    @RequestMapping(value = "/provider/port", method = RequestMethod.GET)
    String getPort();
}