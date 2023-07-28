//package com.imShare.security;
//import com.imShare.service.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    private MyUserDetailService userDetailService;
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login","/register").permitAll()
//                        .requestMatchers("/index","/user/**").hasAnyRole("USER","ADMIN")
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//
//                ).formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login").passwordParameter("password").usernameParameter("username")
//                                .defaultSuccessUrl("/index")
//                                .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//                ).sessionManagement(session->{
//                    session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                            .invalidSessionUrl("/logout").maximumSessions(1).maxSessionsPreventsLogin(false);//cài đặt 1 thằng đăng nhập
//                }).exceptionHandling(excep->{
//                    excep
//                            .authenticationEntryPoint(new Http403ForbiddenEntryPoint()).accessDeniedPage("/error-fob");
//                });
//        return http.build();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//
//}
//
