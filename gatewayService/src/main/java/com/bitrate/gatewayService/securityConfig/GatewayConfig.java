package com.bitrate.gatewayService.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes (RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(r -> r
                        .path("/bitrate/users/**")
                        .filters(f -> f
//                                .filter(authenticationFilter) // no auth token for users routes
                                .rewritePath("/bitrate/users/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://USERS"))
                .route(r -> r
                        .path("/bitrate/video-metadata/**")
                        .filters(f -> f
                                .filter(authenticationFilter)
                                .rewritePath("/bitrate/video-metadata/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://VIDEOMETADATAS"))
                .build();
    }

}
