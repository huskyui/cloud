package com.huskyui.gateway.config;

import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huskyui
 * @date 2020/4/1 16:50
 */
@Configuration
public class BeanConfig {


    //    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r -> r.path("/consumer/**")
//                        .filters(f->f.stripPrefix(1)
//                                    .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//                        .uri("lb://eureka-consumer")
//                        .order(0)
//                        .id("consumer_service")
//
//                ).build();
//    }
//    @Bean
//    public RouteLocator beforeLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.before(LocalDateTime.now().atZone(ZoneId.systemDefault())).uri("http://baeldung.com")
//                ).build();
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes().
//                route(r -> r.method(HttpMethod.GET)
//                        .uri("localhost:9000")
//        ).build();
//    }

//    @Bean
//    public RouteLocator customerRouteLocator2(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r
//                        .method(HttpMethod.POST).and().path("/**").and().cookie("token", "kee.e")
//                        .filters(f -> f
//                                .addRequestParameter("foo", "huskyui")
//                        )
//                        .uri("lb://eureka-consumer").id("first")
//                ).build();
//    }

//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.predicate(t -> {
//                            List<String> values= t.getRequest().getHeaders().get("token");
//                            if(values==null || values.isEmpty()){
//                                return false;
//                            }
//                            return values.stream().anyMatch(value->value.equals("123456"));
//                        })
//                                .uri("lb://eureka-consumer").id("first")
//                ).build();
//    }

//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/consumer/**")
//                        .filters(f->f.stripPrefix(1))
//                                .uri("lb://eureka-consumer").id("first")
//                ).build();
//    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/producer/**")
                        .filters(f -> f.stripPrefix(1)
                                .modifyRequestBody(Map.class, Map.class, MediaType.APPLICATION_JSON_VALUE, (serverWebExchange, s) -> {
                                    System.out.println(s);
                                    s.put("name","adios");
                                    return Mono.just(s);
                                }))
                        .uri("lb://eureka-producer").id("first")
                ).build();
    }
}
