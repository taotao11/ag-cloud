package com.cloud;

import com.cloud.entity.TbAdmin;
import com.cloud.service.TbAdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试类
 */

@RunWith(SpringRunner.class)
//启动测试
@SpringBootTest
public class TbAdminControllerTest {
    @Autowired
    TbAdminService service;

    /**
     * 测试查询方法
     */
    @Test
    public void selectById(){
        TbAdmin tbAdmin = service.selectById(4);
        //断言
        Assert.assertEquals("123",tbAdmin.getUpass());
    }
}
