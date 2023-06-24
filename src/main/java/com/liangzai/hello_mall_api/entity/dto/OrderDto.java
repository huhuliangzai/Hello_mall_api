package com.liangzai.hello_mall_api.entity.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long userId;
    private Long itemId;
    private String receiver;
    private String shippingAddress;
    private String status;
}
