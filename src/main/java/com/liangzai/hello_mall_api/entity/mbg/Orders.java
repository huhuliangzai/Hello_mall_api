package com.liangzai.hello_mall_api.entity.mbg;

import java.math.BigDecimal;
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
    public class Orders implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 订单ID
     */
        @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 用户ID,关联用户表
     */
      private Long userId;


      /**
     * 订单创建时间
     */
      private LocalDateTime ordersCreatedAt;

      /**
     * 订单更新时间
     */
      private LocalDateTime ordersUpdatedAt;


}
