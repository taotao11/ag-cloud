package com.cloud.controller;





import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cloud.entity.Result;
import com.cloud.entity.TbAdmin;
import com.cloud.enums.ResultEnums;
import com.cloud.exception.MyException;
import com.cloud.form.UpdateForm;
import com.cloud.service.TbAdminService;
import com.cloud.util.ResultUtil;
import com.cloud.util.UtilsMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taotao
 * @since 2018-03-03
 */
@RestController
@RequestMapping("/tbAdmin")
public class TbAdminController {
    @Autowired
    private TbAdminService service;

    /**
     * 异常处理测试
     *
     */
    @RequestMapping("/handle")
    public Result handle() throws Exception{
        throw new MyException(ResultEnums.UNKNOW_ERROR);
    }
    /**
     * 查询测试
     * @return
     */
    @RequestMapping("/select")
    public Result<List> selectAll(){
       List<TbAdmin> tbAdmin = service.selectList(new EntityWrapper<TbAdmin>());
        System.out.println(tbAdmin);
        return ResultUtil.success(tbAdmin);
    }
    @RequestMapping("/selectOne")
    public Result selectOne(){
        TbAdmin tbAdmin = service.selectById(4);
        System.out.println(tbAdmin);
        if (tbAdmin == null){
            return ResultUtil.error(0,"没有当前用户!!!");
        }
        return ResultUtil.success(tbAdmin);

    }
    @RequestMapping("/insertAdmin")
    public Result insertTbAdmin(@Valid UpdateForm admin, BindingResult result){
        String message = UtilsMethods.clickCompanyFormData(result);

        if ( message != null){
            return ResultUtil.error(0,message);
        }
        TbAdmin tbAdmin = admin.convertAdminBean();
        if (service.updateById(tbAdmin)) {
            return ResultUtil.success();
        }
        return ResultUtil.error(0,"未知错误！！");
    }
    @RequestMapping("/string")
    public String string(){

        return "success";
    }

}

