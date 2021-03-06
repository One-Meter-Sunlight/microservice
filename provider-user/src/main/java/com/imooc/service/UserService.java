package com.imooc.service;

import com.imooc.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * 用户管理 Service
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
public interface UserService {

    List<User> list();

    Optional<User> selectEntity(Integer id);

    void deleteUserById(Integer id);
}
