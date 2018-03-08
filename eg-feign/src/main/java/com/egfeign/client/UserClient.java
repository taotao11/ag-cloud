package com.egfeign.client;

import com.egfeign.entity.TbAdmin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "ag-user",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping(value = "/tbAdmin/select")
    public List<TbAdmin> selectAll();

    @RequestMapping("/tbAdmin/string")
    public String string();

    @RequestMapping("/tbAdmin/selectOne")
    public TbAdmin selectOne();
}
