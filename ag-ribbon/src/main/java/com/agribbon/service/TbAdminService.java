package com.agribbon.service;

import com.agribbon.entity.TbAdmin;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * service 层
 */
@Service
public class TbAdminService {
    /**
     * 远程服务调用
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询测试
     *  @HystrixCommand(fallbackMethod = "ServiceMethod")
     *  开启断路机制 当发生错误时 自动调用ServiceMethod方法
     * @return
     */
    @HystrixCommand(fallbackMethod="serviceMethod")
    public List<TbAdmin> selectAll(){
        List<TbAdmin> list = restTemplate.getForObject("http://ag-user/tbAdmin/select",List.class);
        System.out.println(list);
        return list;
    }
    /**
     * 断路时调用方法
     *
     */
    public List<TbAdmin> serviceMethod(){
        List<TbAdmin> list = new ArrayList<TbAdmin>();
        System.out.println("发生断路");
        return list;
    }
}
