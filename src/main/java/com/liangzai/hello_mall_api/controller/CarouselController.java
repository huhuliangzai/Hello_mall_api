package com.liangzai.hello_mall_api.controller;


import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.CarouselImg;
import com.liangzai.hello_mall_api.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarouselController {

    @Autowired
    CarouselService caroulService;

    @GetMapping("/carousel")
    @ResponseBody
    public Result getCarsoulImg(CarouselImg carouselImg){
        return caroulService.getImg(carouselImg);
    }
}
