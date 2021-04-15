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
			.antMatchers("/confirmation").permitAll()
			.antMatchers("/styleSheets/custom.css").permitAll()
		//authorizes all in images
			.antMatchers("/images/**").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login").permitAll()
			
		.and()
			.logout().permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
			
	}
	
	// IMPLEMENT A METHOD TO ADD USERS WITHOUT ADDING THIS CODE, REPEATED, OVER AND OVER
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() 
	{
		UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("@earth")
				.password("thePlaneteers")
				.roles("USER")
				.build();
		UserDetails user2 =
				User.withDefaultPasswordEncoder()
					.username("@wind")
					.password("thePlaneteers")
					.roles("USER")
					.build();
		UserDetails user3 =
				User.withDefaultPasswordEncoder()
					.username("@fire")
					.password("thePlaneteers")
					.roles("USER")
					.build();
		UserDetails user4 =
				User.withDefaultPasswordEncoder()
					.username("@water")
					.password("thePlaneteers")
					.roles("USER")
					.build();
		
		UserDetails user23 =
				User.withDefaultPasswordEncoder()
					.username("@heart")
					.password("thePlaneteers")
					.roles("USER")
					.build();
		
		UserDetails user7 =
				User.withDefaultPasswordEncoder()
					.username("slideOverFly")
					.password("the_penguin")
					.roles("USER")
					.build();
		UserDetails user24 =
				User.withDefaultPasswordEncoder()
					.username("seveirein")
					.password("password")
					.roles("USER")
					.build();
		
		UserDetails user5 =
				User.withDefaultPasswordEncoder()
					.username("Lucy Hu")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user6 =
				User.withDefaultPasswordEncoder()
					.username("Nico.Roy")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user8 =
				User.withDefaultPasswordEncoder()
					.username("Stephen Tobin")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user9 =
				User.withDefaultPasswordEncoder()
					.username("Ahmad_Holland")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user10 =
				User.withDefaultPasswordEncoder()
					.username("Arman Singh")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user11 =
				User.withDefaultPasswordEncoder()
					.username("Amg<Alex>")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user12 =
				User.withDefaultPasswordEncoder()
					.username("angela_wheatley")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user13 =
				User.withDefaultPasswordEncoder()
					.username("Debra Debbie Deb or Dee")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user14 =
				User.withDefaultPasswordEncoder()
					.username("FlyTrueGamer")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user15 =
				User.withDefaultPasswordEncoder()
					.username("iTookThatPersonally")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user16 =
				User.withDefaultPasswordEncoder()
					.username("StephenT")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user17 =
				User.withDefaultPasswordEncoder()
					.username("KassiaV")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user18 =
				User.withDefaultPasswordEncoder()
					.username("Kelanim13")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user19 =
				User.withDefaultPasswordEncoder()
					.username("Ronisha Isham")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user20 =
				User.withDefaultPasswordEncoder()
					.username("milk")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user21 =
				User.withDefaultPasswordEncoder()
					.username("Sharyl S.")
					.password("password")
					.roles("USER")
					.build();
		UserDetails user22 =
				User.withDefaultPasswordEncoder()
					.username("Steve_Silva")
					.password("password")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user, user2, user3, user4);
		
	}

}
