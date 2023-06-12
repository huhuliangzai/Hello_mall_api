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
    public class Users implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 用户ID
     */
        @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 用户名
     */
      private String userName;

      /**
     * 用户密码
     */
      private String password;

      /**
     * 用户电子邮件
     */
      private String email;

      /**
     * 用户电话号码
     */
      private String userPhone;

      /**
     * 用户爱好
     */
      private String userHabby;

      /**
      * 用户性别
      */
      private String gender;

      /**
     * 用户地址
     */
      private String address;

    /**
     * 用户地址
    */
      private String avatar;

      /**
     * 用户创建时间
     */
      private LocalDateTime createdAt;

      /**
     * 用户最后更新时间
     */
      private LocalDateTime updatedAt;


}
