package com.liangzai.hello_mall_api.service.impl;

import com.liangzai.hello_mall_api.entity.mbg.Orders;
import com.liangzai.hello_mall_api.mapper.OrdersMapper;
import com.liangzai.hello_mall_api.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}