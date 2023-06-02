package com.liangzai.hello_mall_api;


import com.liangzai.hello_mall_api.entity.mbg.CarouselImg;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.entity.dto.UserLogin;
import com.liangzai.hello_mall_api.mapper.CarouselMapper;
import com.liangzai.hello_mall_api.mapper.UsersMapper;
import com.liangzai.hello_mall_api.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HelloMallApiApplicationTests {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CarouselMapper carouselMapper;
    @Autowired
    private UsersService usersService;
    private UserLogin user;

    @Test
    void testGetAll() {
        List<Users> usersList = usersMapper.selectList(null);
        System.out.println(usersList);
    }

    @Test
    void getCarsoulImg(){
        List<CarouselImg> carsoulImgs = carouselMapper.selectList(null);
        System.out.println(carsoulImgs);
    }



}
