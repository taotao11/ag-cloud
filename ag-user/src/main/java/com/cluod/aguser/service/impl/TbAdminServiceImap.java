package com.cluod.aguser.service.impl;



import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cluod.aguser.entity.TbAdmin;
import com.cluod.aguser.mapper.TbAdminDao;
import com.cluod.aguser.service.TbAdminService;
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
