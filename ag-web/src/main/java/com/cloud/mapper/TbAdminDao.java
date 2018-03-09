package com.cloud.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cloud.entity.TbAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author taotao
 * @since 2018-03-03
 */
@Component
@Mapper
public interface TbAdminDao extends BaseMapper<TbAdmin> {

}
