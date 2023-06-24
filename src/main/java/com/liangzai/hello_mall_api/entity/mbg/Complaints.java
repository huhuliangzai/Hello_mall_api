package com.liangzai.hello_mall_api.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
 @EqualsAndHashCode(callSuper = false)
public class Complaints implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 投诉ID
     */

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private String userName;

    private String complaint;

    private String userPhone;
}
