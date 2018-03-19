package com.jpa.controller;

import com.jpa.entity.TbAdmin;
import com.jpa.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbAdminController {

    @Autowired
    private TbAdminService service;
    @RequestMapping("/select")
    public List<TbAdmin> selectAll(){
        return service.selectAll();
    }
    @RequestMapping("/uname")
    public  List<TbAdmin> findByUname(){
        return service.findByUname();
    }
    @RequestMapping("/or")
    public List<TbAdmin> findByUsexOrUname(){
        return  service.findByUsexOrUname();
    }
    @RequestMapping("/jpql")
    public List<TbAdmin> findByJpql(){
        return  service.findByJpql();
    }

    /**
     * 测试缓存
     * @param id
     * @return
     */
    @RequestMapping("/findId")
    public TbAdmin findOne(int id){
        System.out.println("进入controller层 : findOne: id = " + id);
       return service.findOne(id);
    }

    /**
     * 清空缓存
     * @return
     */
    @RequestMapping("/delet")
    public String delet(int id){
        System.out.println("开始清理缓存：delete : id = " + id);
        service.delet(id);
        return "success";
    }
}
