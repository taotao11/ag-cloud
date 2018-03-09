package com.cloud.exception;

import com.cloud.enums.ResultEnums;

/**
 *
 * 自定义异常
 * spring 只对 RuntimeException 做异常回滚
 */
public class MyException extends RuntimeException {
    private Integer code;

    public MyException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
