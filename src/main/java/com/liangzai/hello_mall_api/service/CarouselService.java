package com.liangzai.hello_mall_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.CarouselImg;

public interface CarouselService extends IService<CarouselImg> {
    Result getImg(CarouselImg carouselImg);
}
