package com.yc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "PAYMENT-ORDER-SERVICE",fallback = PaymentCallBack.class)
public interface PaymentService {

    @GetMapping("/getServerPort")
    public String getServerPort();
}
