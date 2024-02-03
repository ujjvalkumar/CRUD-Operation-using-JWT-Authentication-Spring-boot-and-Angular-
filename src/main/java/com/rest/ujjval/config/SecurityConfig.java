package com.rest.ujjval.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rest.ujjval.security.JWTAuthenticationEntryPoint;
import com.rest.ujjval.security.JWTAuthenticationFilter;

@Configuration
public class SecurityConfig {
	@Autowired 
	JWTAuthenticationEntryPoint point;
	@Autowired 
	JWTAuthenticationFilter filter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		 
		httpSecurity.csrf(http -> http.disable())
		.cors(cor ->cor.disable())
		.authorizeHttpRequests(auth ->auth.requestMatchers("/home/**")
		.authenticated().requestMatchers("/auth/login").permitAll().anyRequest()
        .authenticated()).exceptionHandling(ex ->ex.authenticationEntryPoint(point))
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}

	

}
