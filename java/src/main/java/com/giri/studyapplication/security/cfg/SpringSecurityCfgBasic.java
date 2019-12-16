package com.giri.studyapplication.security.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)///java/src/main/resources/spring-security-thymleaf.xml
public class SpringSecurityCfgBasic extends WebSecurityConfigurerAdapter {


	  @Bean
	  public UserDetailsService Userdetailserviceimpl() {
	    return new Userdetailserviceimpl();
	  };
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(Userdetailserviceimpl()).passwordEncoder(passwordEncoder());
 	//auth.inMemoryAuthentication().withUser("giri").password(passwordEncoder().encode("giri")).roles("GIRI");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/index").hasRole("GIRI")
		.antMatchers("/Photos").hasRole("GIRI")
		.and().formLogin()
		.loginPage("/login").permitAll()
		.failureUrl("/login-error").permitAll()
		.defaultSuccessUrl("/index")
		.and()
		.logout()
		.logoutSuccessUrl("/login").permitAll();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
