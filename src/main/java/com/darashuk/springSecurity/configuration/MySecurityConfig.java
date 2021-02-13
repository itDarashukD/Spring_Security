package com.darashuk.springSecurity.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override  //сделана возможность аутентификации для перечисленных пользователей
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //дефолтный создатель паролей

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("dima").password("dima").roles("EMPLOYEE"))
                .withUser(userBuilder.username("vika").password("vika").roles("HR"))
                .withUser(userBuilder.username("vlad").password("vlad").roles("MANAGER","HR"));

    }
    //сделана возможность авторизации для перечисленных пользователей для конкретных ссылок(кнопой к браузере)
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE","HR","MANAGER")
                .antMatchers("/hr_info").hasAnyRole("HR","MANAGER")
                .antMatchers("/manager_info").hasAnyRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
