package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Categories;
import com.liangzai.hello_mall_api.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/getAllCategories")
    @ResponseBody
    public Result getAllCategories(Categories categories) {
        return categoriesService.getAllCategories(categories);
    }

}

