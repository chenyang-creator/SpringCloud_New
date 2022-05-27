package com.yc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {
    @Bean
    //使用系统提供的负载均衡策略，要想找到服务名所对应的Ip，要有这个注解
    //实际就是通过这个注解，向该RestTemplate对象中添加了一个拦截器，
    //这个拦截器的作用就是返回目标Uri
    //拦截器通过 LoadBalancerAutoConfiguration 自动配置类里边进行配置
    //如果自定义规则，则不要使用当前注解
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
