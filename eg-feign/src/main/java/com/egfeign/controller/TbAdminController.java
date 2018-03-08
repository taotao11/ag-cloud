package com.egfeign.controller;

import com.egfeign.client.UserClient;
import com.egfeign.entity.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private UserClient userClient;

    /**
     * 查询测试
     * @return
     */
    @RequestMapping("/select")
    public List<TbAdmin> selectAll(){

        return userClient.selectAll();
    }

    /**
     * 测试单个查询
     * @return
     */
    @RequestMapping("/selectOne")
    public TbAdmin selectOne(){

        return userClient.selectOne();
    }

    /**
     * 测试返回字符串
     * @return
     */
    @RequestMapping("/string")
    public String string(){

        return userClient.string();
    }
}

