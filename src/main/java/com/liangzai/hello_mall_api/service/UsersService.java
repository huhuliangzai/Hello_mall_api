package com.liangzai.hello_mall_api.service;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.entity.dto.UserRegister;
import com.liangzai.hello_mall_api.entity.vo.LoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
public interface UsersService extends IService<Users> {

    boolean register(UserRegister userRegister);

    Users selectByLoginName(String loginName);

    Result login(UserLogin userLogin);

    Result editInformation(Users users);

    Result getUser(Users users);
}
