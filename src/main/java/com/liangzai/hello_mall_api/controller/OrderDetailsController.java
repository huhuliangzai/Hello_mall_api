package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.OrderDetails;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 * 、
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/orderDetails")
@CrossOrigin
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;

}

