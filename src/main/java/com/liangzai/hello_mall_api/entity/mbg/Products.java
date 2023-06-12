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
    public class Products implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 商品ID
     */
        @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 商品名称
     */
      private String name;

      /**
     * 商品描述
     */
      private String description;

      /**
     * 商品价格
     */
      private BigDecimal price;

      /**
     * 商品库存数量
     */
      private String quantity;

      /**
     * 商品主图
     */
      private String image;

      /**
     * 商品分类ID
     */
      private Long categoryId;


}
