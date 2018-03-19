package com.security.service.serviceimpl;

import com.security.constant.RoleConstant;
import com.security.entity.UserEntity;
import com.security.repository.UserRepositiry;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositiry userMapper;

    //新增
    @Override
    public UserEntity insert(UserEntity userEntity) {
        String username = userEntity.getUsername();
        if (exist(username))
            return null;
        encryptPassword(userEntity);
        userEntity.setRoles(RoleConstant.ROLE_USER);
        UserEntity user = userMapper.save(userEntity);
        return  user;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username){
        UserEntity userEntity = userMapper.findByUsername(username);
        return (userEntity != null);
    }

    /**
     * 加密密码
     */
    private void encryptPassword(UserEntity userEntity){
        String password = userEntity.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userEntity.setPassword(password);
    }
}
