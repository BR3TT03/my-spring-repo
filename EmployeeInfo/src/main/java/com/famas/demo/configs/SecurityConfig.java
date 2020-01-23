package com.famas.demo.configs;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.famas.demo.Security.CustomAccessDeniedHandler;
import com.famas.demo.Security.CustomAuthenticationFailureHandler;
import com.famas.demo.Security.CustomAuthenticationProvider;
import com.famas.demo.Security.CustomAuthenticationSuccessHandler;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider authProvider;

	@Autowired
	CustomAuthenticationSuccessHandler authSuccessHandler;

	@Autowired
	CustomAuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().disable()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
				.and()
				.authorizeRequests()
				.antMatchers("/employeeInfo").permitAll()
				.antMatchers("/employeeInfo/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/login").permitAll()
				.antMatchers("/EmployeeImages/**").permitAll()
				.antMatchers("/resources/static/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
				.usernameParameter("user")
				.passwordParameter("pass")
				.loginProcessingUrl("/authenticate").successHandler(authSuccessHandler)
				.failureHandler(authenticationFailureHandler);
				
		 
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
	}

	
	  @Bean public BCryptPasswordEncoder passwordEncoder() { 
		  return new BCryptPasswordEncoder(); 
		  }
	  
	  @Bean
	  public AccessDeniedHandler accessDeniedHandler(){
	      return new CustomAccessDeniedHandler();
	  }
	  

}
