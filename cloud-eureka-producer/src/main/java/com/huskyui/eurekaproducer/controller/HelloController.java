package com.huskyui.eurekaproducer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author huskyui
 * @date 2020/3/20 15:17
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestBody JSONObject requestJSON) {
        String name = requestJSON.getString("name");
        return "hello, " + name + " " + new Date();
    }
}
