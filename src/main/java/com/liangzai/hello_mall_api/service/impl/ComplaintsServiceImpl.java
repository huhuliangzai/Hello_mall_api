package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Collection;
import com.liangzai.hello_mall_api.entity.mbg.Complaints;
import com.liangzai.hello_mall_api.mapper.CollectionMapper;
import com.liangzai.hello_mall_api.mapper.ComplaintsMapper;
import com.liangzai.hello_mall_api.service.CollectionService;
import com.liangzai.hello_mall_api.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsServiceImpl extends ServiceImpl<ComplaintsMapper, Complaints> implements ComplaintsService {

    @Autowired
    private ComplaintsMapper complaintsMapper;

    @Override
    public Result insertComplant(Complaints complaints) {
        int insert = complaintsMapper.insert(complaints);
        return insert >= 1 ?
                Result.succ(200,"Success",null)
                :
                Result.fail(400,"Failed to insert",null);
    }
}
