package com.imooc.controller;

import com.imooc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @GetMapping("/list")
    public List<User> list() {
        return restTemplate.getForObject("http://127.0.0.1:8080/user/list", List.class);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://127.0.0.1:8080/user/" + id, User.class);
    }
}
