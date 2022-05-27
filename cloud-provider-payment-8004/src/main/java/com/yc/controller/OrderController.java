package com.yc.controller;

import com.yc.service.PaymentService8004;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final PaymentService8004 paymentService8004;

    public OrderController(PaymentService8004 paymentService8004) {
        this.paymentService8004 = paymentService8004;
    }

    @GetMapping("/getServerPort")
    public String getServerPort() throws InterruptedException {
        return paymentService8004.getServerPort();
    }
}
