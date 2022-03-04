package com.academic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.academic.security.CustumUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustumUserDetailsService custumUserDetailsService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().antMatchers(HttpMethod.GET, "/api/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();

	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(custumUserDetailsService).passwordEncoder(passwordEncoder());
	}

	/*
	 * @Override
	 * 
	 * @Bean protected UserDetailsService userDetailsService() { UserDetails jose =
	 * User.builder().username("jose").password(passwordEncoder().encode("jose")).
	 * roles("USER") .build();
	 * 
	 * UserDetails admin =
	 * User.builder().username("admin").password(passwordEncoder().encode("admin")).
	 * roles("ADMINISTRADOR") .build();
	 * 
	 * return new InMemoryUserDetailsManager(jose,admin); }
	 */
}
