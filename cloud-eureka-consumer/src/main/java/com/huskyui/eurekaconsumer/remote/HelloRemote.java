package com.huskyui.eurekaconsumer.remote;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huskyui
 * @date 2020/3/20 15:43
 */
@FeignClient(name = "eureka-producer")
public interface HelloRemote {
    @RequestMapping("/hello")
    String hello(@RequestBody JSONObject requestJSON);
}
