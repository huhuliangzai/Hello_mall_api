package com.liangzai.hello_mall_api.controller;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.entity.mbg.Complaints;
import com.liangzai.hello_mall_api.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaints")
public class ComplaintsController {
    @Autowired
    private ComplaintsService complaintsService;

    @PostMapping("/insertComplant")
    public Result insertComplant(@RequestBody Complaints complaints){
        return complaintsService.insertComplant(complaints);
    }
}
