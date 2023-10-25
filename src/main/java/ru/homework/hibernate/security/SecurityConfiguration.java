package ru.homework.hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Nik")
                .password(encoder().encode("password1"))
                .authorities("read", "write")
                .and()
                .withUser("Den")
                .password(encoder().encode("password2"))
                .authorities("read")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/persons/by-name").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/persons/by-age").hasAuthority("write")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/persons/by-city").hasAuthority("read")
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();
    }
}