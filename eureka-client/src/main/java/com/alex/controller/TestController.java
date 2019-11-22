package com.alex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Registration registration; // 服务注册

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/actuator/info")
    public String info() {
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        StringBuilder s = new StringBuilder();
        if (!CollectionUtils.isEmpty(instances)) {
            for (ServiceInstance instance : instances) {
                String info = "host：" + instance.getHost() + "，service_id：" + instance.getServiceId();
                log.info(info);
                s.append(info);
            }
        }
        return s.toString();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
