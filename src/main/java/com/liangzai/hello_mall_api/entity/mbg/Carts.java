package com.liangzai.hello_mall_api.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Carts implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 购物车ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户ID，关联用户表
     */
      private Integer userId;

      /**
     * 购物车创建时间
     */
      private LocalDateTime cartsCreatedAt;

      /**
     * 购物车更新时间
     */
      private LocalDateTime cartsUpdateAt;


}
