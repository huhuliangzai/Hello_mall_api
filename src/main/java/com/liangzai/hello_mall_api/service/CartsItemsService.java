package com.liangzai.hello_mall_api.service;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.dto.InsertCartItemDto;
import com.liangzai.hello_mall_api.entity.mbg.CartsItems;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzai.hello_mall_api.entity.mbg.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
public interface CartsItemsService extends IService<CartsItems> {

    Result getCartsItemByUser(Users users);

    Boolean deleteCartsItem(CartsItems cartsItems);

    Result insertCartsItem(InsertCartItemDto insertCartItemDto);
}
