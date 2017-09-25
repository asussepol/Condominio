package com.condominio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
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
				.antMatchers("/**").permitAll()
				.antMatchers("/resources/**").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("maria").password("maria").roles("USER").and()
			.withUser("cesar").password("cesar").roles("ADMIN");
			
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
