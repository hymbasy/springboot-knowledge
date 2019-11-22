package com.alex.controller;

import com.alex.model.User;
import com.alex.service.OrderService;
import com.alex.service.StockService;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Reference
    private StockService stockService;
    @Reference
    private OrderService orderService;

    @RequestMapping("/getUser")
    public String getUser() {
        List<User> users = stockService.listUser();
        return JSON.toJSONString(users);
    }

    @RequestMapping("/getOrders")
    public String getOrders() {
        return JSON.toJSONString(orderService.listOrders());
    }
}
