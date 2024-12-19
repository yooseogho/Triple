package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .antMatchers("/", "/login", "/signup", "/css/**", "/resources/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .usernameParameter("id")
                .passwordParameter("passwd")
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true) // 상대 경로로 수정
                .failureUrl("/login?error=true") // 상대 경로로 수정
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/") // 상대 경로로 수정
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
            );

        return http.build();
    }
}
