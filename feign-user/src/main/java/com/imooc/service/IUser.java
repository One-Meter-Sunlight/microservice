package com.imooc.service;

import com.imooc.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户接口
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-13
 */
@FeignClient("provider-user")
public interface IUser {

    @GetMapping("/user/{id}")
    User getUsers(@PathVariable("id") Integer id);

}
