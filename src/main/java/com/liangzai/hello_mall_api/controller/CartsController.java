package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.entity.mbg.Carts;
import com.liangzai.hello_mall_api.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/carts")
public class CartsController {

    @Autowired
    private CartsService cartsService;

    @GetMapping("list")
    public List<Carts> list() {
        return cartsService.list();
    }

    @PostMapping("add")
    public String list(Carts carts) {
        boolean save = cartsService.save(carts);
        return save ? "true" : "false";
    }



}

