package com.boss.xtrain.authentication.configuration;


import com.boss.xtrain.authentication.error.Oauth2AuthenticationFailureHandler;
import com.boss.xtrain.authentication.error.Oauth2AuthenticationSuccessHandler;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BesUserDetailService userDetailService;
    @Autowired
    private Oauth2AuthenticationFailureHandler failureHandler;
    @Autowired
    private Oauth2AuthenticationSuccessHandler successHandler;
    /* 加密密码
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    @Bean
    public PasswordEncoder noEncryptPasswordEncoder() {
        return new NoEncryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/userlogin","/userlogout","/userjwt");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.exceptionHandling().authenticationEntryPoint(new AuthExceptionEntryPoint())
            .csrf().disable()
            .cors().and()
            .authorizeRequests()
            .antMatchers("/login", "/api/token_parse", "/oauth/logout")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .successHandler(successHandler)
            .failureHandler(failureHandler)
            .and()
            .logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(noEncryptPasswordEncoder());
    }

    /**
     * 不定义没有password grant_type
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
