package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.dto.UpdataAvatarDto;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.entity.dto.UserRegister;
import com.liangzai.hello_mall_api.entity.vo.LoginVo;
import com.liangzai.hello_mall_api.mapper.UsersMapper;
import com.liangzai.hello_mall_api.service.UsersService;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
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
    private UsersService usersService;


    @PostMapping("register")
    public Result register(@RequestBody UserRegister userRegister){
        String userName = userRegister.getUserName();
        String password = userRegister.getPassword();
        String email = userRegister.getEmail();
        String phone = userRegister.getUserPhone();
        System.out.println(userName+" "+password+" "+email+" "+phone);
//        对用户注册的Password进行MD5加密后存入数据库
//        userRegister.setPassword(DigestUtils.md5DigestAsHex(userRegister.getPassword().getBytes()));
        boolean u = usersService.register(userRegister);
        if(u){
            return Result.succ(200,"注册成功",usersService.selectByLoginName(userRegister.getUserName()));
        }
        return Result.fail(404,"注册失败,用户已存在!!");
    }


    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin){
        String userName = userLogin.getUserName();
        String password = userLogin.getPassword();
        System.out.println(userName + " " + password);
//        对用户登录Password进行MD5加密后与数据库的机密后密码进行比对
//        userLogin.setPassword(DigestUtils.md5DigestAsHex(userLogin.getPassword().getBytes()));
        return usersService.login(userLogin);
    }

    @PostMapping("/editInformation")
    public Result editInformation(@RequestBody Users users){
        return usersService.editInformation(users);
    }

    @PostMapping("/getUser")
    public Result getUser(@RequestBody Users users){
        return usersService.getUser(users);
    }


    //文件上传
    //指定上传文件的路径
    private  static final String UPLOAD_DIR = "D:/Desktop/MyVueProject/Hello_mall/Hello_mall_vue/src/assets/image/User/avater";
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file){
        try {
            String fileName = file.getOriginalFilename();//构建上传文件的保存路径
            String filePath = Paths.get(UPLOAD_DIR,fileName).toString();//保存文件到本地文件夹
            file.transferTo(Paths.get(filePath));
            System.out.println(fileName);
            return Result.succ(200,"文件上传成功",file.getOriginalFilename());
        }catch (Exception e){
            e.printStackTrace();//返回错误信息
            return Result.fail(400, "上传失败",HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateAvatar")
    public Result updateAvatar(@RequestBody UpdataAvatarDto updataAvatarDto){
        return usersService.updateAvatar(updataAvatarDto);
    }

}

