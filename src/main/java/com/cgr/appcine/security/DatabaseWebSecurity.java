package com.cgr.appcine.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, status from user where username=?")
		.authoritiesByUsernameQuery("select u.username, p.type_profile from pk_user_profile up " +
			"inner join user u on u.id = up.id_User " +
			"inner join profiles p on p.id_profile = up.id_Profile " +
			"where u.username = ?");
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// Los recursos estáticos no requieren autenticación
		.antMatchers(
			"/bootstrap/**",
			"/images/**",
			"/tinymce/**",
			"/logos/**",
			"/admin/assets/**",
			"/assets/**",
			"/neflix/**").permitAll()
        // Asignar permisos a URLs por ROLES
        .antMatchers("/categorias/**").hasAuthority("Registered")
   
        .antMatchers("/categorias/**","/admin/**").hasAnyAuthority("Admin")
        
        
		// Las vistas públicas no requieren autenticación
		.antMatchers("/").permitAll()
			
		// Todas las demás URLs de la Aplicación requieren autenticación
		.anyRequest().authenticated()
		// El formulario de Login no requiere autenticacion
		.and().formLogin().permitAll();
	}
	
	/**
	 *  Implementación de Spring Security que encripta passwords con el algoritmo Bcrypt
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
