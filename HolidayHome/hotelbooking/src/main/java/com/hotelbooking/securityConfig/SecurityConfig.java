package com.hotelbooking.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hotelbooking.utils.JwtFilters;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Autowired
private JwtFilters jwtfilter;
@Autowired
private UserDetailsService userdetailsservice;
@Autowired
private PasswordEncoder passwordencoder;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/user/signup","/api/user/home","/api/user/signin","/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html")
            .permitAll()
            .requestMatchers("/api/user/{id}/*","/api/user/**").hasRole("ADMIN")
//            .requestMatchers("/api/hotels/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST")
            .requestMatchers("/api/hotels/**").permitAll()
            .requestMatchers("/api/rooms/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST")
            .requestMatchers("/api/roomtypes/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST")
            .requestMatchers("/api/bookings/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST", "GUEST")
            .requestMatchers("/api/reviews/**").hasAnyRole("ADMIN", "MANAGER", "GUEST")
            .requestMatchers("/api/payment/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST", "GUEST")
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
return http.build();


}
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
}

@Bean
AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userdetailsservice);
    authProvider.setPasswordEncoder(passwordencoder);

    return authProvider;
}
}
