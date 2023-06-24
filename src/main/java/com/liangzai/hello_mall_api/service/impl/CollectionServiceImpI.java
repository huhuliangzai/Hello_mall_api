package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Collection;
import com.liangzai.hello_mall_api.entity.mbg.Products;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.mapper.CollectionMapper;
import com.liangzai.hello_mall_api.mapper.ProductsMapper;
import com.liangzai.hello_mall_api.service.CollectionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CollectionServiceImpI extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public Result getMyCollection(Users users) {
        Long userId = users.getId();
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id",userId);
        List<Collection> AllCollection = collectionMapper.selectByMap(map);
        List<Long> proId = new ArrayList<>();
        for(int i = 0; i < AllCollection.size(); i++){
            proId.add(AllCollection.get(i).getProductId());
        }
        List<Products> product = productsMapper.selectBatchIds(proId);
        if(ObjectUtils.isEmpty(product)){
            return Result.fail(400,"not found");
        }
        return Result.succ(200,"获取成功",product);
    }

    @Override
    public Result insertCollection(Collection collection) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("product_id", collection.getProductId());
        List<Collection> collectionDB = collectionMapper.selectByMap(map);
        if(CollectionUtils.isEmpty(collectionDB)){
            int insert = collectionMapper.insert(collection);
            return insert >= 1 ?
                    Result.succ(200,"success",null)
                    :
                    Result.fail(400,"not found");
        }
        return Result.fail(400,"已存在");
    }

    @Override
    public Result deleteCollection(Products products) {
        Collection collection = new Collection();
        collection.setProductId(products.getId());
        HashMap<String,Object> map = new HashMap<>();
        map.put("product_id",collection.getProductId());

        int d = collectionMapper.deleteByMap(map);
        return d >= 1 ?
                Result.succ(200,"success",null)
                :
                Result.fail(400,"error",null);
    }
}
