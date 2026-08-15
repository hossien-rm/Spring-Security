package com.shayan.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
       JdbcUserDetailsManager theJdbcUserDetailsManager=new  JdbcUserDetailsManager(dataSource);

       theJdbcUserDetailsManager
               .setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");

       theJdbcUserDetailsManager
               .setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");

       return theJdbcUserDetailsManager;

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){

        http.authorizeHttpRequests(configure->
                       configure                                             // restrict based on roles.
                               .requestMatchers("/").hasRole("EMPLOYEE")
                               .requestMatchers("/leaders/**").hasRole("MANAGER")
                               .requestMatchers("/system/**").hasRole("ADMIN")
                               .anyRequest().authenticated()                // mention every request should authenticate
                )
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")            // should write code in controller which return html page.
                                .loginProcessingUrl("/authenticateTheUser") //check user and password and no need code in controller.
                                .permitAll()                                // allow all request to login page.
                )
                .logout(LogoutConfigurer::permitAll
                )
                .exceptionHandling(configure->  // make custom page when access denied
                        configure.accessDeniedPage("/access-denied")

                );


        return http.build();
    }
}
