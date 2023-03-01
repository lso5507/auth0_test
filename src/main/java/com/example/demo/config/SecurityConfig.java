package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.controller.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private  LogoutHandler logoutHandler;


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.oauth2Login()
			.and()
			.logout()
				// .logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.addLogoutHandler(logoutHandler)
			.and()
			.build();
	}
}
