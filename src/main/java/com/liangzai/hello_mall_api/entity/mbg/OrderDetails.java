package com.liangzai.hello_mall_api.entity.mbg;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    public class OrderDetails implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 订单详情ID
     */
        @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 订单ID,关联订单表
     */
      private Long orderId;

      /**
     * 商品ID，关联商品表
     */
      private Long productId;

      /**
     * 商品名称
     */
      private String productName;

      /**
     * 商品价格
     */
      private BigDecimal productPrice;

      /**
     * 商品数量
     */
      private String quantity;

      /**
     * 订单总价
     */
      private BigDecimal orderTotal;

      /**
    * 收货人
    */
      private String receiver;

      /**
    * 商品数量
    */
      private String shippingAddress;

      /**
    * 订单状态
    */
      private String status;
}
