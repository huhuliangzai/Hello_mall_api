package com.liangzai.hello_mall_api.entity.dto;

import lombok.Data;

@Data
public class UserRegister {
    private Long id;

    private String userName;

    private String email;

    private String userPhone;

    private String password;
}
