package com.yc.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentCallBack implements PaymentService {
    @Override
    public String getServerPort() {
        return "当前服务器异常，请稍后再试！";
    }
}
