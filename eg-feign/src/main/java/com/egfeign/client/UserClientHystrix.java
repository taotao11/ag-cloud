package com.egfeign.client;

import com.egfeign.entity.TbAdmin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 断路器 实现类
 *
 *  @Component注入到Ioc容器中
 */
@Component
public class UserClientHystrix implements UserClient {
    @Override
    public List<TbAdmin> selectAll() {
        return new ArrayList<TbAdmin>();
    }

    @Override
    public String string() {
        return "error";
    }

    @Override
    public TbAdmin selectOne() {
        return new TbAdmin();
    }
}
