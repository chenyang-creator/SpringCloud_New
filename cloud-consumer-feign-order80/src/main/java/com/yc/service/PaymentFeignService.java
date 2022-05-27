package com.yc.service;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/getServerPort")
    CommonResult<String> getServerPort();
}
