package com.yc.controller;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import com.yc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("****节点{},插入Payment实体:{}****",serverPort,payment);
        if(i > 0){
            log.info("****节点{},插入Payment实体:{}成功****",serverPort,payment);
            return new CommonResult<>(200,"节点:"+serverPort+"插入成功",payment);
        }else{
            log.info("****插入Payment实体:{}失败****",payment);
            return new CommonResult<>(444,"节点:"+serverPort+"插入成功");
        }
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        log.info("*****节点{},查询id:{}*****",serverPort,id);
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****节点{}，查询结果{}*****",serverPort,paymentById);
        if(paymentById == null)
            return new CommonResult<>(444,"通过节点:"+serverPort+"查询无记录");
        return new CommonResult<>(200,"通过节点:"+serverPort+"查询",paymentById);
    }

    @GetMapping("/getServerPort")
    public CommonResult<String> getServerPort(){
/*        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("getServerPort:{}",serverPort);
        return new CommonResult<>(200,"success",serverPort);
    }
}
