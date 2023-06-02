package com.liangzai.hello_mall_api.mapper;

import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
