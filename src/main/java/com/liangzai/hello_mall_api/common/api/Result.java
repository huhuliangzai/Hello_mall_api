package com.liangzai.hello_mall_api.common.api;

import lombok.Data;

import java.io.Serializable;


/**
 * 返回前端状态类
 */
@Data
public class Result implements Serializable{

    //    响应状态码,200为正常
    private Integer status;
    //    响应消息
    private String message;
    //    结果数据
    private Object data;

    public Result() {
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result( String message, Object data) {
        this.message = message;
        this.data = data;
    }


    //  对成功的结果进行封装，不用每次都自己填status和message，只需要把数据传进来就可以了
    public static Result succ(Object data) {
        return succ(200, "请求成功", data);
    }

    public static Result succ(String messgae,Object data){
        return succ(200,messgae,data);
    }

    public static Result succ(Integer status, String message, Object data) {
        return new Result(status,message,data);
    }

    public static Result fail(String message) {
        return fail(400, message, null);
    }

    public static Result fail(Integer status, String message){
        return fail(status,message,null);
    }

    public static Result fail(String message, Object data) {
        return fail(400, message, data);
    }

    public static Result fail(Integer status, String message, Object data) {
        return new Result(status,message,data);
    }


}