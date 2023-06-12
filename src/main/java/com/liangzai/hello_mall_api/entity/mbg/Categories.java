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
    public class Categories implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 分类ID
     */
        @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 分类名称
     */
      private String categoryName;

      /**
     * 父分类ID，表示当前分类是哪个分类的子分类
     */
      private Long parentId;


}
