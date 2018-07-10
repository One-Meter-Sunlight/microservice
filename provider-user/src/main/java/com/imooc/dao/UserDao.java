package com.imooc.dao;

import com.imooc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理 Dao
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
