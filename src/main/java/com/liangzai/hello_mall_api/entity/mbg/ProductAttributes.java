package com.liangzai.hello_mall_api.entity.mbg;

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
    public class ProductAttributes implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 商品属性id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 商品属性名
     */
      private String productAttributeName;

      /**
     * 属性值，例如300g
     */
      private String value;

      /**
     * 商品id
     */
      private Long productId;


}
