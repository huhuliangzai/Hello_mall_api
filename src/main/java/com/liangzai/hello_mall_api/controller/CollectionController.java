package com.liangzai.hello_mall_api.controller;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @GetMapping("/getMyCollection")
    public Result getMyCollection(Users users){
        return collectionService.getMyCollection(users);
    }
}
