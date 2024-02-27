package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("auth_public_route", r -> r.path("/api/v1/public/auth/**").uri("http://localhost:8081"))
				.route("auth_route", r -> r.path("/api/v1/**").uri("http://localhost:8081"))
				.route("product_route", r -> r.path("/api/v1/**").uri("http://localhost:8082")).build();
	}
}