package com.employee.dimitar.config;

import com.employee.dimitar.service.LoginDetailsService;
import com.employee.dimitar.util.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The SecurityConfig class configures security settings for the application.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    /**
     * The service to retrieve user details for authentication.
     */
    private final LoginDetailsService loginDetailsService;

    /**
     * Constructs a SecurityConfig object with the specified LoginDetailsService.
     *
     * @param loginDetailsService The service to retrieve user details for authentication.
     */
    @Autowired
    public SecurityConfig(LoginDetailsService loginDetailsService) {
        this.loginDetailsService = loginDetailsService;
    }

    /**
     * Configures security settings for HTTP requests.
     *
     * @param security The HttpSecurity object to configure.
     * @throws Exception if an error occurs while configuring security.
     */
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/templates/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .defaultSuccessUrl("/home", true)
                .and()
                .logout().permitAll();
    }

    /**
     * Configures authentication manager with the provided user details service and password encoder.
     *
     * @param auth The AuthenticationManagerBuilder object to configure.
     * @throws Exception if an error occurs while configuring authentication manager.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginDetailsService).passwordEncoder(Encoder.getEncoder());
    }
}
