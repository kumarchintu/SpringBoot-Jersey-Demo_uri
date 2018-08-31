package com.google.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.google.util.EmployeeResource;

@Component
public class JersyConfig extends ResourceConfig {
	public JersyConfig() {
		register(EmployeeResource.class);
	}
}
