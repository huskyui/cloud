package com.huskyui.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
/**
 * Sets up a Zuul server endpoint and installs some reverse proxy filters in it, so it can
 * forward requests to backend servers. The backends can be registered manually through
 * configuration or via DiscoveryClient.
 * */
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

}
