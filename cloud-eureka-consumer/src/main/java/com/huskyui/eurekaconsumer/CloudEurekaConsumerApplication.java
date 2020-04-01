package com.huskyui.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CloudEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaConsumerApplication.class, args);
    }

}
