package com.huskyui.consumerfeignhystrix.fallback;

import com.alibaba.fastjson.JSONObject;
import com.huskyui.consumerfeignhystrix.remote.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * @author huskyui
 * @date 2020/3/23 13:59
 */

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(JSONObject requestJSON) {
        return "hello world";
    }
}
