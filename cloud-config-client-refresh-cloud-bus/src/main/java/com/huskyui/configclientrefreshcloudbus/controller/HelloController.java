package com.huskyui.configclientrefreshcloudbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huskyui
 * @date 2020/3/24 17:40
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${currency.name:error}")
    private String name;


    @RequestMapping("/hello")
    public String name(){
        return name;
    }
}
