package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

// 애플리케이션의 시작점을 정의하는 클래스
@SpringBootApplication // Spring Boot의 자동 설정, 컴포넌트 스캔 등을 활성화하는 어노테이션
public class DemoApplication extends SpringBootServletInitializer {

    // Spring Boot 애플리케이션을 외부 Tomcat과 같은 서블릿 컨테이너에서 실행할 수 있도록 설정
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // DemoApplication 클래스를 애플리케이션 소스로 등록
        return builder.sources(DemoApplication.class);
    }

    // WebApplicationContext를 초기화하는 메서드 (옵션)
    // 필요에 따라 애플리케이션 컨텍스트를 설정하거나 커스터마이징할 수 있음
    @Override
    protected WebApplicationContext run(SpringApplication application) {
        return super.run(application); // 기본 동작을 유지
    }

    // 애플리케이션의 진입점 (main 메서드)
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); // Spring Boot 애플리케이션 실행
    }
}
	