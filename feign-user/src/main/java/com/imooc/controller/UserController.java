package com.imooc.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.imooc.domain.User;
import com.imooc.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消费者-用户Contorller
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-10
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUser userService;

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUsers(id);
    }
}
