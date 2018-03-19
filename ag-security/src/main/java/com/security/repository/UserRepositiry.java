package com.security.repository;

import com.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositiry extends JpaRepository<UserEntity,Long> {
    public UserEntity findByUsername(String userName);
}
