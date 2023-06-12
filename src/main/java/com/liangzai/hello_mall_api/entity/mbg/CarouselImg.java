package com.liangzai.hello_mall_api.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
    @EqualsAndHashCode(callSuper = false)
     public class CarouselImg implements Serializable {

     private static final long serialVersionUID=1L;

     private  Long id;

    private String imgName;
}
