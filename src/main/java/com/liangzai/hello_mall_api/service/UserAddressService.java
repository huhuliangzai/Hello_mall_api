package com.liangzai.hello_mall_api.service;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
public interface UserAddressService extends IService<UserAddress> {

    Result getAddress(UserAddress userAddress);
}
