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
            .csrf(csrf -> csrf.disable()) // CSRF 비활성화
            .authorizeHttpRequests(auth -> auth
                .antMatchers("/", "/login", "/signup", "/css/**", "/resources/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .usernameParameter("id")
                .passwordParameter("passwd")
                .loginPage("/login")
                .defaultSuccessUrl("http://200.200.200.163:30080/", true) // 절대 경로 사용
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("http://200.200.200.163:30080/") // 로그아웃 후 절대 경로
            );

        return http.build();
    }
}
