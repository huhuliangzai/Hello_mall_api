package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.UserAddress;
import com.liangzai.hello_mall_api.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/address")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;


    @PostMapping ("/getAddress")
    public Result getAddress(@RequestBody UserAddress userAddress){
        Long userId = userAddress.getUserId();
        System.out.println(userId);
        return userAddressService.getAddress(userAddress);
    }
}

