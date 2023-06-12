package com.liangzai.hello_mall_api.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
    public class UserAddress implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 用户地址id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户表的主键关联，表示该地址属于哪个用户
     */
      private Long userId;

      /**
     * 收件人姓名
     */
      private String name;

      /**
     * 收件人电话号码
     */
      private String phoneNumber;

      /**
     * 收件人详细地址
     */
      private String addressDetail;

      /**
     * 邮政编码
     */
      private Integer zipCode;

      /**
     * 默认为0,0为不是默认地址，1为默认地址
     */
      private Integer isDefault;

      /**
     * 地址创建时间
     */
        @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      /**
     * 地址最后修改时间
     */
        @TableField(fill = FieldFill.INSERT_UPDATE)
      private LocalDateTime updateTime;


}
