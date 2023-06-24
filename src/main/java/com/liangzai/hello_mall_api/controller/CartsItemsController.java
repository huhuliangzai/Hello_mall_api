package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.dto.InsertCartItemDto;
import com.liangzai.hello_mall_api.entity.mbg.CartsItems;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.service.CartsItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/cartsItems")
public class CartsItemsController {

    @Autowired
    private CartsItemsService cartsItemsService;

    @GetMapping("/getCartsItemByUser")
    public Result getCartsItemByUser(Users users){
        Long userId = users.getId();
        System.out.println("用户ID:"+userId);

        return cartsItemsService.getCartsItemByUser(users);
    }

    @GetMapping("/deleteCartsItem")
    public Result deleteCartsItem(CartsItems cartsItems){
        boolean u = cartsItemsService.deleteCartsItem(cartsItems);
        if(u){
            return Result.succ(200,"删除成功", true);
        }
        return Result.fail(400,"订单不存在");
    }

    @GetMapping("/insertCartsItem")
    public Result insertCartsItem(InsertCartItemDto insertCartItemDto){
        System.out.println(insertCartItemDto);
        return cartsItemsService.insertCartsItem(insertCartItemDto);
    }

    @GetMapping("/getItem")
    public Result getItem(CartsItems cartsItems){
        return cartsItemsService.getItem(cartsItems);
    }
}

