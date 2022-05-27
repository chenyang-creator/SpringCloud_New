package com.yc.myLoadbalanced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLBImp implements MyLB {

    private AtomicInteger integer = new AtomicInteger(0);

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        log.info("第{}次访问",integer.get());

        int andIncrement = integer.getAndIncrement();

        return instances.get(andIncrement % instances.size());
    }
}
