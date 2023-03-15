package com.pm.finalproject.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //nuimam csrf filtra
        http
                .csrf()
                .disable();

        //nustatom, kad nekurtu sesijos security
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // sukonfiguruojam endpointu autorizacijos reikalavimus
        http
                .authorizeRequests()
                .antMatchers(
                        "projects/all"
                ).permitAll();
        return http.build();
    }
}
