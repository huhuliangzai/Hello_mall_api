package com.liangzai.hello_mall_api.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsertCartItemDto {
    private Long userId;
    private Long productId;
    private Integer Quantity;
    private BigDecimal total;
}
