package com.sahariar.Shopaholic.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
       auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("Select email,password,true from user where email = ?")
       .authoritiesByUsernameQuery("Select email,role from user where email = ? ");
    }
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/admin").access("hasRole('Role_ADMIN')").anyRequest().permitAll();
		
		
		
	}
	
	
}
