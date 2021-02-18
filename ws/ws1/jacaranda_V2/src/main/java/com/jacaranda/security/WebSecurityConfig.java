package com.jacaranda.security;

<<<<<<< Updated upstream

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
>>>>>>> Stashed changes
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.jacaranda.security.common.SecurityConstants;
import com.jacaranda.security.filter.JWTAuthenticationFilter;
import com.jacaranda.security.filter.JWTAuthorizationFilter;
import com.jacaranda.security.model.UserRole;
import com.jacaranda.security.service.UserService;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private JWTAuthorizationFilter jwtAuthorizationFilter;
	 
	@Autowired
	private UserService userService;
	
	@Autowired 
	private PasswordEncoder passWordEncoder;
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
		
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().anyRequest();
	}
	
<<<<<<< Updated upstream
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/*").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//	}
=======
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
			.antMatchers(HttpMethod.POST, SecurityConstants.LOG_IN).permitAll()
			.antMatchers(HttpMethod.GET, "/customer/*").hasRole(UserRole.USER.name())
			.antMatchers(HttpMethod.POST, "/customer/*").hasRole(UserRole.ADMIN.name())
			.anyRequest().authenticated()
		.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
			.addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
>>>>>>> Stashed changes
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}

}
