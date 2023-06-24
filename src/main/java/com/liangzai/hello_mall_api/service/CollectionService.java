package com.liangzai.hello_mall_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Collection;
import com.liangzai.hello_mall_api.entity.mbg.Products;
import com.liangzai.hello_mall_api.entity.mbg.Users;

public interface CollectionService extends IService<Collection> {

    Result getMyCollection(Users users);

    Result insertCollection(Collection collection);

    Result deleteCollection(Products products);
}
