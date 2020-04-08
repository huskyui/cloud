package com.huskyui.gatewayfilter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author huskyui
 * @date 2020/4/1 17:23
 */

public class ElapsedFilter implements GatewayFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(ElapsedFilter.class);
    private static final String ELAPSED_START_TIME = "elapsedTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(ELAPSED_START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(ELAPSED_START_TIME);
            if (startTime != null) {
                logger.info(exchange.getRequest().getURI().getRawPath() + ":" + (System.currentTimeMillis() - startTime) + " ms");
            }
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
