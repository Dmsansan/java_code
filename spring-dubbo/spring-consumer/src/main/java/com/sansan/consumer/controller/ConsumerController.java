package com.sansan.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sansan.api.client.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siss
 * @date 2020/9/2  14:05
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    /**
     *  使用兼容注入，可以使用dubbo原生注解@Reference注入
      */
    @Reference(version = "1.0.0")
    private ProviderService service;

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        return service.sayHello(name);
    }
}
