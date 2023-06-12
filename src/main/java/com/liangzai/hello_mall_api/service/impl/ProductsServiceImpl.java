package com.liangzai.hello_mall_api.service.impl;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Categories;
import com.liangzai.hello_mall_api.entity.mbg.Products;
import com.liangzai.hello_mall_api.mapper.CategoriesMapper;
import com.liangzai.hello_mall_api.mapper.ProductsMapper;
import com.liangzai.hello_mall_api.service.ProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    ProductsMapper productsMapper;

    @Override
    public Result getProducts(Categories category) {
        HashMap<String,Object> category_map = new HashMap<>();
        category_map.put("category_name", category.getCategoryName());
        List<Categories> categories = categoriesMapper.selectByMap(category_map);
        Long categoryId = categories.get(0).getId();

        HashMap<String,Object> product_map = new HashMap<>();
        product_map.put("category_id", categoryId);
        List<Products> products = productsMapper.selectByMap(product_map);
        if (CollectionUtils.isEmpty(products)) {
            return Result.fail(400, "No products");
        }
        return Result.succ(200,"获取成功", products);
    }

    @Override
    public Result getHotSaleProducts(Categories categories) {
        String categoryName = categories.getCategoryName();
        HashMap<String, Object> category_map = new HashMap<>();
        category_map.put("category_name",categoryName);
        List<Categories> hot_saleId = categoriesMapper.selectByMap(category_map);
        Long categoryId = hot_saleId.get(0).getId();

        HashMap<String,Object> product_map = new HashMap<>();
        product_map.put("category_id", categoryId);
        List<Products> products = productsMapper.selectByMap(product_map);
        if (CollectionUtils.isEmpty(products)) {
            return Result.fail(400, "No products");
        }
        return Result.succ(200,"获取成功",products);
    }
}
