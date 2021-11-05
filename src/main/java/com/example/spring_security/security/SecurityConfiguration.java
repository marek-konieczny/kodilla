package com.example.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers( "/m1")
                .hasAnyRole("R3", "R2", "R1")
                .mvcMatchers( "/m2")
                .hasAnyRole("R3", "R2")
                .mvcMatchers("/m3")
                .hasAnyRole("R3")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();

//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .mvcMatchers(HttpMethod.GET, "/m1")
//                .hasAnyRole("R3", "R2", "R1")
//                .mvcMatchers(HttpMethod.POST, "/m2")
//                .hasAnyRole("R3", "R2")
//                .mvcMatchers(HttpMethod.PATCH, "/m3")
//                .hasAnyRole("R3")
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("r1").roles("R1").password("r1");
        auth.inMemoryAuthentication().withUser("r2").roles("R2").password("r2");
        auth.inMemoryAuthentication().withUser("r3").roles("R3").password("r3");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

