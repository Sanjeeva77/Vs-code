package cgg.springboot.db.springbootdbdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import cgg.springboot.db.springbootdbdemo.service.CustomUserDetailsService;

@Configuration
public class MySecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        
        httpSecurity.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/signin").permitAll()
        .requestMatchers("/logout").permitAll()
        .requestMatchers("/public").hasRole("NORMAL")
        .requestMatchers("/users/**").hasRole("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/signin")
        .loginProcessingUrl("/dologin")
        .defaultSuccessUrl("/users");

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    
    @Bean
    public UserDetailsService userDetailsService(){

        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){

       DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
       provider.setUserDetailsService(customUserDetailsService);
       provider.setPasswordEncoder(passwordEncoder());

       return provider;

    }
}
