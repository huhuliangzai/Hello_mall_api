package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.dto.OrderDto;
import com.liangzai.hello_mall_api.entity.mbg.Orders;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired

    private OrdersService ordersService;

    @PostMapping ("/getAllOrders")
    public Result getAllOrders(@RequestBody Users users){
        return ordersService.getAllOrders(users);
    }

    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody OrderDto orderDto){
        return ordersService.createOrder(orderDto);
    }
}

