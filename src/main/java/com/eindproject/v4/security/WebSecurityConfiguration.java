package com.eindproject.v4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    //creating users
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        ;
    }

    //password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //securing endpoints
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()

                //for all
                .antMatchers(HttpMethod.GET,"/agenda").permitAll()

                //for admin only
                .antMatchers(HttpMethod.POST,"/appointments").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/appointments/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/appointments/{id}").hasRole("ADMIN")

                //for customers
                .antMatchers(HttpMethod.PUT, "/appointments/{id}/reserve").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/appointments/{id}/cancel").hasRole("USER")

                //rest
                .and()
//                .anyRequest().permitAll()
//                .and()
                .cors()
                .and()

                //disabled
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
