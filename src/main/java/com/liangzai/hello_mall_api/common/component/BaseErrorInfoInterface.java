package com.liangzai.hello_mall_api.common.component;

public interface BaseErrorInfoInterface {
    /**
     *  错误码
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     * @return
     */
    String getResultMsg();
}
