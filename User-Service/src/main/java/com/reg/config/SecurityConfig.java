package com.reg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.reg.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
        		.cors(cors -> cors.disable())
        		.authorizeHttpRequests(auth -> auth
        				.requestMatchers("/**").permitAll()
       	            .anyRequest().authenticated()
        	     )
        		
        		
                .build();
    }
	
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	 public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		 authenticationProvider.setUserDetailsService(userDetailsService());
		 authenticationProvider.setPasswordEncoder(passwordEncoder());
		 return authenticationProvider;
	 }
	 
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		 return config.getAuthenticationManager();
	 }
}
