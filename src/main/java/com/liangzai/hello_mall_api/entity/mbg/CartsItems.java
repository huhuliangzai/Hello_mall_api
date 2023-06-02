package com.liangzai.hello_mall_api.entity.mbg;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
    public class CartsItems implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 购物车商品ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 购物车ID,关联购物车表
     */
      private Integer cartId;

      /**
     * 商品ID，关联商品表
     */
      private Integer productId;

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
      @TableField("Quantity")
    private Integer Quantity;


}
