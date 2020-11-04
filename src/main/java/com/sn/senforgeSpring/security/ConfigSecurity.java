package com.sn.senforgeSpring.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("gadiaga")
		.password("{noop}passer").roles("responsable","admin");
		
		auth.inMemoryAuthentication().withUser("test")
		.password("{noop}passer").roles("responsable");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/clients","/villages").hasRole("responsable");
		http.authorizeRequests().antMatchers("/ajoutClient", "/ajoutVillage", "/editClient", "/delete").hasRole("admin");
		http.exceptionHandling().accessDeniedPage("/403");
		
	}
}
