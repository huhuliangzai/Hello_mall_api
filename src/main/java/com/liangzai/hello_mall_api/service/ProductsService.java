package com.liangzai.hello_mall_api.service;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Categories;
import com.liangzai.hello_mall_api.entity.mbg.Products;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
public interface ProductsService extends IService<Products> {

    Result getProducts(Categories categories);

    Result getHotSaleProducts(Categories categories);

    Result getProductById(Products products);
}
