package com.imooc.service;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 用户管理 ServiceImp
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Service
public class UserImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> selectEntity(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }
}
