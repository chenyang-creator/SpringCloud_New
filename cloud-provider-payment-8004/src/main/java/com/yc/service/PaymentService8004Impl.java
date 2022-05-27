package com.yc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService8004Impl implements PaymentService8004 {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getServerPort() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int  a = 3;
        log.info("Payment Service Sleep 4s 后的执行a的结果{}",a);
        return "ServerPort:"+serverPort;
    }
}
