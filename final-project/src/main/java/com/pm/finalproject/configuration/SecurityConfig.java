package com.pm.finalproject.configuration;
import com.pm.finalproject.users.JwtService;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtService jwtService) throws Exception {

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
                        "/projects/**",
                        "/login"
                ).permitAll()
//                .antMatchers("/projects/**").access("hasRole('ROLE_PM')")
                .anyRequest()
                .authenticated();

        // autorizacijos filtras, kuris suparsina jwt tokena
        http.addFilterBefore(new JwtAuthorizationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(H2ConsoleProperties properties) {
        return web -> web
                .ignoring()
                .antMatchers(properties.getPath() + "/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }



}
