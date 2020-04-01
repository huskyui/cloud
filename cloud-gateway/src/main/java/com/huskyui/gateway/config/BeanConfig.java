package com.huskyui.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huskyui
 * @date 2020/4/1 16:50
 */
@Configuration
public class BeanConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/consumer/**")
                        .filters(f->f.stripPrefix(1)
                                    .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://eureka-consumer")
                        .order(0)
                        .id("consumer_service")

                ).build();
    }
}