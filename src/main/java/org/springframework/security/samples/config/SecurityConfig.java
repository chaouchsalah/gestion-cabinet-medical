package org.springframework.security.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Logger;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDetailsService userService;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(WebSecurityConfigurerAdapter.class));

  @Autowired
  public final void configureGlobal(AuthenticationManagerBuilder auth) {
      try {
          auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
      } catch (Exception e) {
          LOGGER.warning(e.getMessage());
      }
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
  
  @Override
  public final void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/patient/**").hasRole("PATIENT")
              .antMatchers("/medecin/**").hasRole("MEDECIN")
              .and()
              .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
              .and()
              .logout().logoutSuccessUrl("/login").permitAll()
              .and()
              .csrf().disable();
  }
}