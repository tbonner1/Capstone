package com.hcl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{

	@Autowired
	private UserDetailsService userDetailsService;
	
	 @Bean(name="passwordEncoder")
	 public PasswordEncoder passwordencoder()
	 {
	     return new BCryptPasswordEncoder();
	 }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		 http.authorizeRequests()
		 .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		 .antMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
		  .anyRequest().permitAll()
		  .and()
		  .formLogin().loginPage("/login")
		  .usernameParameter("username").passwordParameter("userpassword")
		  .and()
		  .logout().logoutSuccessUrl("/login?logout") 
		  .and()
		   .exceptionHandling().accessDeniedPage("/403")
		  .and()
		  .csrf().disable();
	}

}
