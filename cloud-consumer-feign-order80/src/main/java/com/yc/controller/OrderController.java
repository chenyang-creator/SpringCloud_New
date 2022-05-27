package com.yc.controller;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import com.yc.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    String name = "aaa";
    private final PaymentFeignService paymentFeignService;

    public OrderController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/getServerPort")
    public CommonResult<String> getServerPort(){
        return paymentFeignService.getServerPort();
    }

  /*  @GetMapping("/getPaymentById/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }*/
}
