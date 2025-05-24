package com.travelapi3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable() // for testing; don't disable in production
                .authorizeHttpRequests()
                .anyRequest().permitAll(); // allow all requests without authentication
        return http.build();
    }


//    private JwtFilterRequest jfr;
//
//    public SecurityConfiguration(JwtFilterRequest jfr) {
//        this.jfr = jfr;
//    }

//    @Bean
//    SecurityFilterChain sfc(HttpSecurity http) throws Exception{
//
//        http.csrf().disable().cors().disable();
//
//
//        http.addFilterBefore(jfr, AuthorizationFilter.class);
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/api/travel3/**").permitAll()
//                .requestMatchers("/practiseapi/pp/add1").hasRole("ADMIN")
//                .requestMatchers("/practiseapi/pp/getdetails").hasRole("USER")
//                .anyRequest().authenticated();
//
////        .requestMatchers("/api/travel3/**").permitAll()
////                .requestMatchers("/practiseapi/pp/add1").hasRole("ADMIN")
////                .anyRequest().authenticated()
//        return http.build();
//    }

}
