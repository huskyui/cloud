package com.huskyui.consumerfeignhystrix.controller;

import com.alibaba.fastjson.JSONObject;
import com.huskyui.consumerfeignhystrix.remote.HelloRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huskyui
 * @date 2020/3/23 14:00
 */
@RestController
public class HelloController {

    @Resource
    private HelloRemote helloRemote;


    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name")String name){
        JSONObject requestJSON = new JSONObject();
        requestJSON.put("name",name);
        return helloRemote.hello(requestJSON);
    }
}
