package com.alex.service;

import com.alex.model.Order;
import org.apache.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yanhuihui
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> listOrders() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setDesc("ceshi ");
        order.setId(1);
        order.setOrderAmt(BigDecimal.valueOf(1000.00));
        order.setUserId(1);
        orders.add(order);
        return orders;
    }
}
