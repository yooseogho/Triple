package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    // 톰캣에서 실행하기 위한 설정
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

	@Override
	protected WebApplicationContext run(SpringApplication application) {
		return super.run(application);
	}
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
