package com.cloud.enums;

/**
 * 统一维护
 * 统一错误信息提示
 */
public enum ResultEnums {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1,"success"),
    ERROR(0,"失败!!!")
    ;

    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
