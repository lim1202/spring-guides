package com.example.spring.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class SwaggerProvider implements SwaggerResourcesProvider {
	public static final String API_DOCS_URI = "/v3/api-docs";

	private List<Map<String, String>> routes;

	public List<Map<String, String>> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Map<String, String>> routes) {
		this.routes = routes;
	}

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>(routes.size());
		for (Map<String, String> entry : routes) {
			resources.add(swaggerResource(entry.get("id"), String.format("/%s%s", entry.get("id"), API_DOCS_URI), "3.0"));
		}
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
