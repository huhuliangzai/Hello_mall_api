package com.liangzai.hello_mall_api.service.impl;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Categories;
import com.liangzai.hello_mall_api.mapper.CategoriesMapper;
import com.liangzai.hello_mall_api.service.CategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {

    @Autowired
    CategoriesMapper categoriesMapper;

    @Override
    public Result getAllCategories(Categories categories) {
        List<Categories> categoryList = categoriesMapper.selectList(null);
        if (CollectionUtils.isEmpty(categoryList)) {
            return Result.fail(400,"No categories");
        }
        return Result.succ(200,"获取成功",categoryList);
    }
}
