package com.transfer.room.config.security;

import com.transfer.room.config.security.filter.JwtAuthenticationFilter;
import com.transfer.room.config.security.filter.JwtAuthorizationFilter;
import com.transfer.room.user.service.CustomUserDetailsService;
import com.transfer.room.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, UserService userService){
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/uploads/**", "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
                "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager();

        http
                .csrf().disable()   // csrf와 session은 JWT 기반 Security에서는 사용하지 않으므로 disable 처리 (remove csrf and state in session because in jwt we do not need them)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager)) // jwt filters 추가
                .addFilter(new JwtAuthorizationFilter(authenticationManager, this.userService))
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "").permitAll()
//                .antMatchers(HttpMethod.POST, "").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}