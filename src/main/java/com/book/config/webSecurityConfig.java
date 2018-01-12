package com.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.book.service.customUserService;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class webSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	UserDetailsService customUserService() {
		// TODO Auto-generated method stub
		return new customUserService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
		.antMatchers("/registry").anonymous()
		.antMatchers("/regin").anonymous()
		.antMatchers("/unv").anonymous()
		.antMatchers("/tosearch","/search").anonymous()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
		.and()
		.logout()
		.permitAll();
	}
	
	@Override
	public void configure(WebSecurity webSecurity){
		webSecurity.ignoring().antMatchers("/global/**");
	}
}
