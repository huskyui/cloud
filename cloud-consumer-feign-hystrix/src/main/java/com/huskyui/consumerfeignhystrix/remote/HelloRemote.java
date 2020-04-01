package com.huskyui.consumerfeignhystrix.remote;

import com.alibaba.fastjson.JSONObject;
import com.huskyui.consumerfeignhystrix.fallback.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huskyui
 * @date 2020/3/23 13:56
 */
@Component
@FeignClient(name = "eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello(@RequestBody JSONObject requestJSON);
}
