package com.cloud.handle;

import com.cloud.entity.Result;
import com.cloud.exception.MyException;
import com.cloud.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 自定义异常处理类
 */
@ControllerAdvice
public class ExceptionHandle {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    //指定异常接受类型
    @ExceptionHandler(value = Exception.class)
    //返回到网页
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof MyException) {
            return ResultUtil.error(((MyException) e).getCode(), e.getMessage());
        }
        logger.info("-- 系统异常 -- ： --{}--",e);
        return ResultUtil.error(-1,"系统错误");
    }
}
