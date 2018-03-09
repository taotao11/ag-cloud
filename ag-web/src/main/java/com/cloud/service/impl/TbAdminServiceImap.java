package com.cloud.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.entity.TbAdmin;
import com.cloud.mapper.TbAdminDao;
import com.cloud.service.TbAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taotao
 * @since 2018-03-03
 */
@Service("tbAdminService")
public class TbAdminServiceImap extends ServiceImpl<TbAdminDao, TbAdmin> implements TbAdminService {

}
