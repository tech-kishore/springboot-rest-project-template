package com.kishore.restfulwebservices.security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {

//	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//1. Response to preflight request doesn't pass access control check
		//2. basic auth check url   '/basicauth'
		
		http
		.authorizeHttpRequests(
				auth -> auth
				.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll() //1
				.anyRequest().authenticated()
				)
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.csrf().disable();
		return http.build();
	}

}
