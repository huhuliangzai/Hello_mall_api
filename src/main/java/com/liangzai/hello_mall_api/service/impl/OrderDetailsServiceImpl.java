package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.OrderDetails;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.mapper.OrderDetailsMapper;
import com.liangzai.hello_mall_api.service.OrderDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public Result changeStatus(OrderDetails orderDetails) {
        QueryWrapper<OrderDetails> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(OrderDetails::getId, orderDetails.getId());
        OrderDetails orderDetailItem = orderDetailsMapper.selectById(orderDetails.getId());
        orderDetailItem.setStatus("1");
        int update = orderDetailsMapper.update(orderDetailItem, wrapper);
        return update >=1 ?
                Result.succ(200,"Success",null)
                :
                Result.fail(400,"Invalid order",null);
    }
}
