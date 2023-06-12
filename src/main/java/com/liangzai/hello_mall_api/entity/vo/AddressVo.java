package com.liangzai.hello_mall_api.entity.vo;

import com.liangzai.hello_mall_api.entity.mbg.UserAddress;
import lombok.Data;

@Data
public class AddressVo extends UserAddress{
    private Long userId;
}
