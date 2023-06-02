package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.common.util.CopyUtil;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.entity.dto.UserRegister;
import com.liangzai.hello_mall_api.entity.vo.LoginVo;
import com.liangzai.hello_mall_api.mapper.UsersMapper;
import com.liangzai.hello_mall_api.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public boolean register(UserRegister userRegister) {
        Users user = CopyUtil.copy(userRegister, Users.class);
        if (ObjectUtils.isEmpty(userRegister.getId())){
            Users userDB = selectByLoginName(userRegister.getUserName());
              if (ObjectUtils.isEmpty(userDB)){
                boolean u = usersMapper.insert(user)>0;
                return u;
            }
        }
        return false;
    }

    //    通过名字查询用户
    public Users selectByLoginName(String loginName){
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Users::getUserName,loginName);
        List<Users> usersList = usersMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(usersList)){
            return null;
        }else{
            return usersList.get(0);
        }
    }

    @Override
    public Result login(UserLogin userLogin) {
        Users userDB = selectByLoginName(userLogin.getUserName());
        if (ObjectUtils.isEmpty(userDB)){
            return Result.fail(400,"用户不存在");
        }
        if(userDB.getPassword().equals(userLogin.getPassword())){
            LoginVo loginVo = new LoginVo();
            loginVo.setId(userDB.getId());
//            根据用户id生成token
            loginVo.setToken(UUID.randomUUID().toString());
//            将用户信息插入data
//            loginVo.setUsers(userDB);
            return Result.succ(200,"登录成功",loginVo);
        }
        return Result.fail(400,"登录失败,请确认用户名与密码");
    }


}
