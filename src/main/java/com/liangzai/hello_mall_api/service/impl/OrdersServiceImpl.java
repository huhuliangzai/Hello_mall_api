package com.liangzai.hello_mall_api.service.impl;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.OrderDetails;
import com.liangzai.hello_mall_api.entity.mbg.Orders;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.mapper.OrderDetailsMapper;
import com.liangzai.hello_mall_api.mapper.OrdersMapper;
import com.liangzai.hello_mall_api.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public Result getAllOrders(Users users) {
        Long userId = users.getId();
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<Orders> orders = ordersMapper.selectByMap(map);
        List<Long> order_id = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            Long orderId = orders.get(i).getId();
            order_id.add(orderId);
        }
        System.out.println(order_id);
        List<OrderDetails> ordersDetails = orderDetailsMapper.selectBatchIds(order_id);
        if (CollectionUtils.isEmpty(ordersDetails)){
            return Result.fail(400, "Not orders");
        }
        return Result.succ(200,"获取成功",ordersDetails);
    }
}
