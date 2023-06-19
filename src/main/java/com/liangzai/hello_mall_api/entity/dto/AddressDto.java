package com.liangzai.hello_mall_api.entity.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long userId;
    private String addressDetail;
    private String name;
    private String phoneNumber;
}
