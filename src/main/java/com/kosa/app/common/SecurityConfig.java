package com.kosa.app.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.kosa.app.service.SocialOAuth2UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	SocialOAuth2UserService oAuthService;
	
	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	LoginFailureHandler loginFailureHandler;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			.antMatchers("/", "/member/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/member/login")
			.usernameParameter("memberId")
			.passwordParameter("password")
			.loginProcessingUrl("/member/login")
			.successHandler(loginSuccessHandler)
			.failureHandler(loginFailureHandler);
		
		http.oauth2Login()
			.userInfoEndpoint()
			.userService(oAuthService);
		
		http.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		
		http.csrf().disable();
		
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/image/**"); 
	}
}

