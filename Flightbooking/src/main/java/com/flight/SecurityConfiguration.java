package com.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flight.entities.Role;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(userDetailsService)
									.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
		//DELETE can be performed by ADMIN only
		.authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole(Role.ADMIN)
	
		.antMatchers("/api/v1.0/flight/booking/**","/api/v1.0/flight/airline/**").hasAnyRole(Role.ADMIN, Role.USER)
		.antMatchers("/api/v1.0/flight/stock/add").hasRole(Role.ADMIN)
		.and()
		.authorizeRequests().anyRequest().permitAll().and()
        .exceptionHandling().accessDeniedPage("/403").and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic();
		
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


