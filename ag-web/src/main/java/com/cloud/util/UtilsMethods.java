package com.cloud.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 工具类
 */
public class UtilsMethods {

    /**
     * 检查表单数据验证
     * @param result
     * @return
     */
    public static String clickCompanyFormData(BindingResult result){
        //判断验证信息
        if(result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = result.getFieldErrors();
            //result.rejectValue("","",""); //自定义错误信息(属性名 错误信息 错误类型)
            for (FieldError error : fieldErrors) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage() + ":" + error.getCode());
                sb.append(error.getDefaultMessage());
                sb.append("  :  ");
                sb.append(error.getCode());
            }
            return sb.toString();
        }
        return null;
    }
}
