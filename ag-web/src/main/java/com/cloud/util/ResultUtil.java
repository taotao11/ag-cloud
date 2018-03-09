package com.cloud.util;

import com.cloud.entity.Result;

/**
 * 定义返回类型工具类
 */
public class ResultUtil {
    /**
     * 返回成功时处理方法
     * 有返回数据
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        //设置返回状态码
        result.setCode(1);
        //返回成功提示
        result.setMessage("success");
        result.setDate(object);
        return result;
    }

    /**
     * 返回成功时不带数据
     * @return
     */
    public static  Result success(){
        return success(null);
    }

    /**
     *返回错误时
     * @param code 错误码
     * @param message 错误信息
     * @return
     */
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
