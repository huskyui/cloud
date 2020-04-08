package com.huskyui.gatewayfilter.config;

import com.huskyui.gatewayfilter.filter.ElapsedFilter;
import com.huskyui.gatewayfilter.filter.TokenFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huskyui
 * @date 2020/4/1 17:45
 */
@Configuration
public class BeanConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/fluent/consumer/**")
                        .filters(f -> f.stripPrefix(2)
                                .filter(new ElapsedFilter())
                                .addResponseHeader("X-Response-Default-Foo", "say hello world"))
                        .uri("lb://eureka-consumer")
                        .order(0)
                        .id("fluent_consumer_service")
                ).build();
    }

    @Bean
    public ElapsedFilter elapsedFilter(){
        return new ElapsedFilter();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("path_route",r->r.path("/about").uri("http://www.ityouknow.com/about"))
//                .build();
//    }
}
