package com.tts.trailsummaryapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
			.antMatchers("/console/**").permitAll()
			.antMatchers("/index").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/trailMap").permitAll()
			.antMatchers("/styleSheets/index.css").permitAll()
			.antMatchers("/styleSheets/trailMap.css").permitAll()
			.antMatchers("/images/abstract-forest.svg").permitAll()
			.antMatchers("/images/torreyPinesTrailMap.png").permitAll()
			.anyRequest().authenticated()
			
		.and()
			.formLogin()
			.loginPage("/login").permitAll()
			
		.and()
			.logout().permitAll();
		
		
			
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() 
	{
		UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("michael_albright")
				.password("password")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
