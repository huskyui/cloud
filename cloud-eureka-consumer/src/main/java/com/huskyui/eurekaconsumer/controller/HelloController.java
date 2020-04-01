package com.huskyui.eurekaconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.huskyui.eurekaconsumer.remote.HelloRemote;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huskyui
 * @date 2020/3/20 15:46
 */
@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name")String name){
        JSONObject requestJSon = new JSONObject();
        requestJSon.put("name",name);
        return helloRemote.hello(requestJSon);
    }
}
