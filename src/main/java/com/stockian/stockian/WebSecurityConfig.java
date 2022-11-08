/*
package com.stockian.stockian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {

  @Autowired
  private StockianUserDetailsService userDetailsService;
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  //private BCryptPasswordEncoder egyel;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.cors()
        .disable()
        .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/login").permitAll()
        */
/*.antMatchers("/api/login")*//*

        */
/*.permitAll()*//*

        .anyRequest()
        .authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager(http,userDetailsService)))
            .addFilter(new JWTAuthorizationFilter(authenticationManager(http,userDetailsService)))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    ;

    return http.build();
  }
  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http, StockianUserDetailsService userDetailService)
          throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailService)
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
    source.registerCorsConfiguration("/**", corsConfiguration);

    return source;
  }

}

*/
