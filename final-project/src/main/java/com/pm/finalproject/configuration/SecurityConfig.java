package com.pm.finalproject.configuration;
import com.pm.finalproject.users.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


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
//                        "/projects/**",
                        "/login",
                        "/user",
                        "/",
"/home"
//                        "/user",
//                        "/roles/*",
//                        "/users"
                ).permitAll()
                .antMatchers("/projects/**").hasAnyRole("ADMIN", "PM", "CLIENT")
                .antMatchers("/roles/{userId}").hasRole("ADMIN")
                .antMatchers("/users").hasRole("ADMIN")
                .anyRequest()
                .authenticated();

        // autorizacijos filtras, kuris suparsina jwt tokena
        http.addFilterBefore(new JwtAuthorizationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
        http.cors();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web
                .ignoring()
                .antMatchers( "/h2/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
