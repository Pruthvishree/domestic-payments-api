package com.cg.openbanking.payment.domesticPaymentAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//@Autowired
	//private AuthenticationEntryPoint authenticationEntryPoint;
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests().antMatchers("/user/domestic-payments")
			.authenticated().and()
	          .httpBasic(); 
		http.csrf().disable(); 
		//http.csrf().disable().authorizeRequests().authenticated().and().httpBasic().authenticationEntryPoint(authenticationEntryPoint);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
	}
	
	
	
} 