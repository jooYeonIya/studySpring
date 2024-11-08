package org.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails user = User.builder()
//        .username("user")
//        .password("{noop}1111")
//        .roles("USER")
//        .build();
//
//    UserDetails admin = User.builder()
//        .username("admin")
//        .password("{noop}1111")
//        .roles("ADMIN", "USER")
//        .build();
//
//    return new InMemoryUserDetailsManager(user, admin);
//  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers("/login", "/", "/info", "/any", "/account/new").permitAll() // 누구나 다 들어갈 수 있도록 함
        .requestMatchers("/admin").hasRole("ADMIN") // 이 페이지는 ADMIN 롤만 들어갈 수 있도록 함
        .anyRequest().authenticated();

//    http.formLogin(form -> form.loginPage("/login")
//        .usernameParameter("username")
//        .passwordParameter("password"));

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
