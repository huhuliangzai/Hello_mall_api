package com.liangzai.hello_mall_api.entity.dto;

import lombok.Data;

@Data
public class UpdataAvatarDto {
    private Long userID;
    private String avatar;
}
