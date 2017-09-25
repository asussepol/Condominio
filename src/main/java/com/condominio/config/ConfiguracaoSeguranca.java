package com.condominio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http
			.authorizeRequests()
				.antMatchers("/areaComum/novo").hasRole("ADMIN")
				.antMatchers("/unidades/novo").hasRole("ADMIN")
				.antMatchers("/ocorrencias/novo").hasRole("ADMIN")
				.antMatchers("/presencaReuniao/novo").hasAnyRole("ADMIN","USER")
				.antMatchers("/reservaAreaComum/novo").hasAnyRole("ADMIN","USER")
				.antMatchers("/index/").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/index?logout");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("maria").password("maria").roles("USER").and()
			.withUser("cesar").password("cesar").roles("ADMIN");
			
		
	}
	
	
	
	
	
	
	
	

}
