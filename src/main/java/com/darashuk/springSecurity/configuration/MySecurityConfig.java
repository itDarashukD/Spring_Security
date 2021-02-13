package com.darashuk.springSecurity.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //дефолтный создатель паролей

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("dima").password("dima").roles("EMPLOYEE"))
                .withUser(userBuilder.username("vika").password("vika").roles("HR"))
                .withUser(userBuilder.username("vlad").password("vlad").roles("MANAGER","HR"));


    }
}
