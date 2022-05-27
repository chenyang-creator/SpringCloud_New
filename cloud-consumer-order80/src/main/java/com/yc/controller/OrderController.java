package com.yc.controller;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import com.yc.myLoadbalanced.MyLBImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    private final MyLBImp myLBImp;

    private static final String PAYMENT_SERVICE = "http://SPRINGCLOUD-GATEWAY";

    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient, MyLBImp myLBImp) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.myLBImp = myLBImp;
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_SERVICE + "/getPayment/" + id, CommonResult.class);
    }

    @GetMapping("/payment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_SERVICE + "/payment", payment, CommonResult.class);
    }

    @GetMapping("/getServerPort")
    public CommonResult<String> getServerPort(){
        return restTemplate.getForObject(PAYMENT_SERVICE+"/getServerPort",CommonResult.class);
    }

    /**
     * 使用自定义规则
     * 不能使用@LoadBalanced注解标注RestTemplate
     * @return
     */
    @GetMapping("/getServerPortByCustomerRule")
    public CommonResult<String> getServerPortByCustomerRule(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        ServiceInstance instance = myLBImp.getInstance(instances);

        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/getServerPort",CommonResult.class);
    }
}
