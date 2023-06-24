package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.dto.OrderDto;
import com.liangzai.hello_mall_api.entity.mbg.CartsItems;
import com.liangzai.hello_mall_api.entity.mbg.OrderDetails;
import com.liangzai.hello_mall_api.entity.mbg.Orders;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.mapper.CartsItemsMapper;
import com.liangzai.hello_mall_api.mapper.OrderDetailsMapper;
import com.liangzai.hello_mall_api.mapper.OrdersMapper;
import com.liangzai.hello_mall_api.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private CartsItemsMapper cartsItemsMapper;

    @Override
    public Result getAllOrders(Users users) {
        Long userId = users.getId();
        System.out.println("用户ID: " + userId);
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<Orders> orders = ordersMapper.selectByMap(map);
        if (CollectionUtils.isEmpty(orders)){
            return Result.fail(400, "Not orders");
        }
        List<Long> orderId = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++){
            Long order_id = orders.get(i).getId();
            orderId.add(order_id);
        }
//        System.out.println(orderId);
        HashMap<String,Object> orderDetail_map = new HashMap<>();
        List<Long> order_detail_id = new ArrayList<>();
        for (int i = 0; i < orderId.size(); i++){
            orderDetail_map.put("order_Id",orderId.get(i).toString());
            List<OrderDetails> orderDetails = orderDetailsMapper.selectByMap(orderDetail_map);

            order_detail_id.add(orderDetails.get(0).getId());
        }
        System.out.println(order_detail_id);
        List<OrderDetails> orderItems = orderDetailsMapper.selectBatchIds(order_detail_id);
        if (CollectionUtils.isEmpty(orderItems)) {
            return Result.fail(400,"Invalid order",null);
        }
        return Result.succ(200,"获取成功",orderItems);
    }

    @Override
    public Result createOrder(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setUserId(orderDto.getUserId());
        orders.setOrdersCreatedAt(LocalDateTime.now());
        orders.setOrdersUpdatedAt(LocalDateTime.now());
        int insert = ordersMapper.insert(orders);
        if (insert >= 1){
            System.out.println("创建订单成功");
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(orders.getId());

            CartsItems cartsItem = cartsItemsMapper.selectById(orderDto.getItemId());
            orderDetails.setProductId(cartsItem.getProductId());
            orderDetails.setProductName(cartsItem.getProductName());
            orderDetails.setProductPrice(cartsItem.getProductPrice());
            orderDetails.setQuantity(String.valueOf(cartsItem.getQuantity()));
            orderDetails.setOrderTotal(cartsItem.getTotal());

            orderDetails.setReceiver(orderDto.getReceiver());
            orderDetails.setShippingAddress(orderDto.getShippingAddress());
            orderDetails.setStatus(orderDto.getStatus());

            int insert1 = orderDetailsMapper.insert(orderDetails);

            return insert1 >=1 ?
                    Result.succ(200,"下单成功",null)
                    :
                    Result.fail(400,"失败");
        }
        return Result.fail(400,"失败");
    }
}
