package com.Nathan.OAuth2.Example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/error").permitAll()
                .antMatchers("/protected").authenticated()
                .anyRequest().permitAll()
                // OAuth 2.0
                .and()
                .oauth2Login()
                .loginPage("/loginCustom")
                .defaultSuccessUrl("/protected")
                .and()
                // Form login
                .formLogin()
                .loginPage("/loginCustom")
                .defaultSuccessUrl("/protected")
                // Custom logout
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                // ConcurrentSessionFilter
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);

        return http.build();
    }
}
