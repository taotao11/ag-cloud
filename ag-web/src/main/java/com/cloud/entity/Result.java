package com.cloud.entity;

/**
 * http请求返回的最外层对象
 *
 */
public class Result<T> {
    /**
     * 错误码
     *
     */
    private Integer code;
    /**
     * 提示内容
     *
     */
    private String message;
    /**
     * 数据
     */
    private T date;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
