package com.google;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJersyDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringBootJersyDemoApplication()
				.configure(new SpringApplicationBuilder(SpringBootJersyDemoApplication.class)).run(args);
	}
}