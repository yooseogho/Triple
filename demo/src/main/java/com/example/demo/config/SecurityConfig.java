package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링의 설정 클래스임을 나타냄
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() { // 비밀번호 암호화를 위한 Bean 정의
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder를 사용하여 비밀번호 암호화
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // Spring Security 필터 체인을 설정하는 Bean 정의
        http
            .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (테스트나 API 호출 시 필요)
            .authorizeHttpRequests(auth -> auth
                .antMatchers("/", "/login", "/signup", "/css/**", "/resources/**").permitAll() // 특정 경로에 대해 모든 사용자 접근 허용
                .anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
            )
            .formLogin(form -> form
                .usernameParameter("id") // 로그인 시 사용할 사용자명 필드 이름 설정 (기본: username)
                .passwordParameter("passwd") // 로그인 시 사용할 비밀번호 필드 이름 설정 (기본: password)
                .loginPage("/login") // 사용자 정의 로그인 페이지 경로 설정
                .loginProcessingUrl("/login") // 로그인 처리 요청 경로 설정
                .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 URL 설정 (항상 이동)
                .failureUrl("/login?error=true") // 로그인 실패 시 이동할 URL 설정
                .permitAll() // 로그인 페이지 접근 권한 허용
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // 로그아웃 처리 요청 경로 설정
                .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL 설정
                .invalidateHttpSession(true) // 로그아웃 시 세션 무효화 설정
                .clearAuthentication(true) // 로그아웃 시 인증 정보 제거 설정
                .permitAll() // 로그아웃 페이지 접근 권한 허용
            );

        return http.build(); // 필터 체인 빌드 후 반환
    }
}
