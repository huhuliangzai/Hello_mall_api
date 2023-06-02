package com.liangzai.hello_mall_api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.liangzai.hello_mall_api.mapper"})
public class MybatisConfig {
}
