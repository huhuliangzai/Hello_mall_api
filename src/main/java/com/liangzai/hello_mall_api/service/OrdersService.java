package com.liangzai.hello_mall_api.service;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzai.hello_mall_api.entity.mbg.Users;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
public interface OrdersService extends IService<Orders> {
    Result getAllOrders(Users users);
}
