package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 이 클래스가 설정 클래스임을 나타냄
public class SecurityConfig {

    // 비밀번호를 암호화하는 데 사용하는 빈 정의
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt 알고리즘을 사용한 암호화 구현
    }

    // 스프링 시큐리티 필터 체인을 구성하는 빈 정의
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // HTTP 요청에 대한 권한을 설정
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .authorizeHttpRequests(auth -> auth
                                .antMatchers("/").permitAll()
                                .antMatchers("/login").permitAll() // "/login" 경로는 인증 없이 접근 허용
                                .antMatchers("/signup").permitAll() // "/signup" 경로도 인증 없이 접근 허용
                                .antMatchers("/resources/**").permitAll() // 정적 리소스 경로도 인증 없이 접근 허용
                                .antMatchers("/css/**").permitAll() // CSS 파일 접근 허용
                                .anyRequest().authenticated() // 위에서 허용되지 않은 모든 요청은 인증이 필요
                )
                // 로그인 설정
                .formLogin(form -> form
                                .usernameParameter("id")      // Spring Security가 사용할 파라미터 이름을 "id"로 변경
                                .passwordParameter("passwd")  // Spring Security가 사용할 파라미터 이름을 "passwd"로 변경
                                .loginPage("/login") // 커스텀 로그인 페이지 경로 지정
                                .defaultSuccessUrl("/") // 로그인 성공 시 리다이렉트할 기본 경로
                                .permitAll() // 로그인 관련 URL은 인증 없이 접근 가능
                )
                // 로그아웃 설정
                .logout(logout -> logout
                        .permitAll()
                        .invalidateHttpSession(true) // 로그아웃 시 세션 무효화
                        .clearAuthentication(true)  // 인증 정보 삭제
                        .logoutSuccessUrl("/") // 로그아웃 후 리디렉션할 페이지
                );
        
        
        return http.build(); // 설정을 마무리하고 SecurityFilterChain 객체 반환
    }
    
    
    
}
