package com.cluod.aguser.controller;




import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cluod.aguser.entity.TbAdmin;
import com.cluod.aguser.entity.Test;
import com.cluod.aguser.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * 查询测试
     * @return
     */
    @RequestMapping("/select")
    public List<TbAdmin> selectAll(){
       List<TbAdmin> tbAdmin = service.selectList(new EntityWrapper<TbAdmin>());
        System.out.println(tbAdmin);
        return tbAdmin;
    }
    @RequestMapping("/selectOne")
    public TbAdmin selectOne(){
        TbAdmin tbAdmin = service.selectById(4);
        System.out.println(tbAdmin);
        return tbAdmin;
    }

    @RequestMapping("/string")
    public String string(){

        return "success";
    }

    @RequestMapping("/test")
    public Test test(){
        Test test = new Test();
        test.setName("张三");
        test.setPass("123");
        test.setSix(0);
        return test;
    }
}

