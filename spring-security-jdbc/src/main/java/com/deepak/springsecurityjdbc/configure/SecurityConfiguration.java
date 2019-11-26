package com.deepak.springsecurityjdbc.configure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	// h2 is an embedded dataSource so Spring Security knows to create a data Source
	@Autowired
	private DataSource h2DataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(h2DataSource)
		
		// When want take from differnt table
		.usersByUsernameQuery("Select username, password, enabled from users where username = ?")
		.authoritiesByUsernameQuery("Select username, authority from authorities where username = ?");
		
		// when you want to use default schema
//		.withDefaultSchema()
//		.withUser(User.withUsername("user").password("user").roles("USER"))
//		.withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
