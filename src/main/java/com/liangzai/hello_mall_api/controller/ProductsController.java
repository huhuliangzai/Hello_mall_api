package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Categories;
import com.liangzai.hello_mall_api.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @RequestMapping("/getProducts")
    public Result getProducts(@RequestBody Categories categories){
        String category = categories.getCategoryName();
        System.out.println(category);
        return productsService.getProducts(categories);
    }

    @GetMapping("/getHotSaleProducts")
    public Result getHotSaleProducts(Categories categories){
        return productsService.getHotSaleProducts(categories);
    }


}

