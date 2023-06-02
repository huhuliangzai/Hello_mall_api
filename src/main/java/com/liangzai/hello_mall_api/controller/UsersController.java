package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.entity.dto.UserRegister;
import com.liangzai.hello_mall_api.mapper.UsersMapper;
import com.liangzai.hello_mall_api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@RestController
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersService usersService;


    @PostMapping("register")
    @ResponseBody
    public Result register(@RequestBody UserRegister userRegister){
        String userName = userRegister.getUserName();
        String password = userRegister.getPassword();
        String email = userRegister.getEmail();
        String phone = userRegister.getUserPhone();
        System.out.println(userName+" "+password+" "+email+" "+phone);
//        对用户注册的Password进行MD5加密后存入数据库
//        userRegister.setPassword(DigestUtils.md5DigestAsHex(userRegister.getPassword().getBytes()));
        boolean u = usersService.register(userRegister);
        if(u==true){
            return Result.succ(200,"注册成功",usersService.selectByLoginName(userRegister.getUserName()));
        }
        return Result.fail(404,"注册失败,用户已存在!!");
    }


    @CrossOrigin
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody UserLogin userLogin){
        String userName = userLogin.getUserName();
        String password = userLogin.getPassword();
        System.out.println(userName + " " + password);
//        对用户登录Password进行MD5加密后与数据库的机密后密码进行比对
//        userLogin.setPassword(DigestUtils.md5DigestAsHex(userLogin.getPassword().getBytes()));
        return usersService.login(userLogin);
    }
}

