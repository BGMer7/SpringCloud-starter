// package com.example.feignprovider.service.impl;
//
// import com.example.feignprovider.service.PortService;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
//
// /**
//  * @author -- gatsby
//  * @date -- 2022/4/23
//  * @description -- Port Service Impl
//  */
//
// @Service
// public class PortServiceImpl implements PortService {
//     @Value("${server.port}")
//     private String serverPort;
//
//     @Override
//     public String getPort() {
//         return serverPort;
//     }
// }