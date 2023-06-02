package com.liangzai.hello_mall_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.CarouselImg;
import com.liangzai.hello_mall_api.mapper.CarouselMapper;
import com.liangzai.hello_mall_api.service.CarouselService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, CarouselImg> implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public Result getImg(CarouselImg carouselImg) {
        List<CarouselImg> carouselImgs = carouselMapper.selectList(null);
        if (CollectionUtils.isEmpty(carouselImgs)) {
            return Result.fail(400,"图片获取失败");
        }
        return Result.succ(200,"图片获取成功",carouselImgs);
    }
}
