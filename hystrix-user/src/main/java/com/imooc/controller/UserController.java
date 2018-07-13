package com.imooc.controller;

import com.imooc.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/list")
    public List<User> list() {
        return restTemplate.getForObject("http://PROVIDER-USER/user/list", List.class);
    }

    @GetMapping("/eureka")
    public void eureka() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PROVIDER-USER");
        System.out.println(serviceInstance.getUri());
        // 获得uri之后可以通过httpclient调用改url
    }

    @GetMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrix() {
        return restTemplate.getForObject("http://PROVIDER-USER/user/list", List.class).toString();
    }

    public String fallback() {
        return "error";
    }
}
