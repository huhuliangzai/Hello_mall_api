package com.liangzai.hello_mall_api.entity.vo;

import com.liangzai.hello_mall_api.entity.mbg.Users;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginVo implements Serializable {
    private Long id;
    private String token;
    private Users users;
}
