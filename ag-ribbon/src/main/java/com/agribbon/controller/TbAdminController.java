package com.agribbon.controller;

import com.agribbon.entity.TbAdmin;
import com.agribbon.service.TbAdminService;
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
    private RestTemplate restTemplate;

    @Autowired
    private TbAdminService tbAdminService;

    /**
     * 查询测试
     * @return
     */
    @RequestMapping("/select")
    public List<TbAdmin> selectAll(){
       List<TbAdmin> list = tbAdminService.selectAll();
       System.out.println(list);
        return list;
    }

    /**
     * 测试单个查询
     * @return
     */
    @RequestMapping("/selectOne")
    public TbAdmin selectOne(){
        TbAdmin tbAdmin = restTemplate.getForObject("http://ag-user/tbAdmin/selectOne",TbAdmin.class);
        System.out.println(tbAdmin);
        return tbAdmin;
    }

    /**
     * 测试返回字符串
     * @return
     */
    @RequestMapping("/string")
    public String string(){

        return restTemplate.getForObject("http://ag-user/tbAdmin/string",String.class);
    }
}

