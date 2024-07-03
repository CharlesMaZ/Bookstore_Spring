package com.karol.lab.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/main").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/book/add", "/book/update/**", "/book/delete").hasAuthority("ADMIN") //permitAll()// hasAuthority("ADMIN")


                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        //.defaultSuccessUrl("/home", true)
                        .successHandler(new CustomLoginSuccessHandler())
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form.permitAll())
//                .logout(logout -> logout.permitAll());
//        return http.build();
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println(new BCryptPasswordEncoder());
        return new BCryptPasswordEncoder();
    }




}
