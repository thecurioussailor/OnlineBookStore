//package com.vecv.obsapplication.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http.csrf().disable().
//                authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "api/publishers").hasAnyRole("EMPLOYEE","MANAGER")
//                        .requestMatchers(HttpMethod.GET, "api/publishers/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "api/publishers").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "api/publishers").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "api/publishers/**").hasRole("ADMIN")
//        );
//
//        http.httpBasic(Customizer.withDefaults());
//
//
//
//        return http.build();
//    }
//}
