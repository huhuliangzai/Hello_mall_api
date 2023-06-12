package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.UserAddress;
import com.liangzai.hello_mall_api.entity.vo.AddressVo;
import com.liangzai.hello_mall_api.mapper.UserAddressMapper;
import com.liangzai.hello_mall_api.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.apache.commons.collections.CollectionUtils;
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
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public Result getAddress(UserAddress userAddress) {
        UserAddress addressDB = selectAddressById(userAddress.getUserId());
        if(ObjectUtils.isEmpty(addressDB)){
            return Result.fail(400,"no address found");
        }
        return Result.succ(200,"获取地址成功",addressDB);
    }

    //通过id查address
    public UserAddress selectAddressById(Long userId){
        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserAddress::getUserId,userId);
        List<UserAddress> addresses = userAddressMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(addresses)){
            return null;
        }else {
            return addresses.get(0);
        }
    }
}
