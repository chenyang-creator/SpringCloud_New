package com.yc.myLoadbalanced;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLB {
    ServiceInstance getInstance(List<ServiceInstance> instances);
}
