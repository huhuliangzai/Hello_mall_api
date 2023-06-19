package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.common.util.CopyUtil;
import com.liangzai.hello_mall_api.entity.mbg.Carts;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.entity.dto.UserRegister;
import com.liangzai.hello_mall_api.entity.vo.LoginVo;
import com.liangzai.hello_mall_api.mapper.CartsMapper;
import com.liangzai.hello_mall_api.mapper.UsersMapper;
import com.liangzai.hello_mall_api.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
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
    @Autowired
    private CartsMapper cartsMapper;

    @Override
    public boolean register(UserRegister userRegister) {
        Users user = CopyUtil.copy(userRegister, Users.class);
        Carts carts = new Carts();
        if (ObjectUtils.isEmpty(userRegister.getId())){
            Users userDB = selectByLoginName(userRegister.getUserName());
              if (ObjectUtils.isEmpty(userDB)){
                  user.setCreatedAt(LocalDateTime.now());
                  user.setUpdatedAt(LocalDateTime.now());
                boolean u = usersMapper.insert(user)>0;
                  carts.setUserId(user.getId());
                  carts.setCartsUpdateAt(LocalDateTime.now());
                  carts.setCartsCreatedAt(LocalDateTime.now());
                int insert = cartsMapper.insert(carts);
                  return u;
            }
        }
        return false;
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
            userDB.setPassword(null);
            loginVo.setUsers(userDB);
            return Result.succ(200,"登录成功",loginVo);
        }
        return Result.fail(400,"登录失败,请确认用户名与密码");
    }

    @Override
    public Result editInformation(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Users::getId,users.getId());
        int update = usersMapper.update(users, wrapper);
        return update >= 1 ? Result.succ(null) : Result.fail("");
    }

    @Override
    public Result getUser(Users users) {
        Long userId = users.getId();
        Users user = usersMapper.selectById(userId);
        if(ObjectUtils.isEmpty(user)){
            return Result.fail("400");
        }
        return Result.succ(200,"获取用户成功",user);
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

}
