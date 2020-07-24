package com.boss.xtrain.authentication.configuration;


import com.boss.xtrain.authentication.error.Oauth2AuthenticationFailureHandler;
import com.boss.xtrain.authentication.error.Oauth2AuthenticationSuccessHandler;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p> 配置web服务器 <br>
 * </p>
 *
 * @author lzx
 * @version 1.0.0
 * @date 2020.07.15
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BesUserDetailService userDetailService;
    @Autowired
    private Oauth2AuthenticationFailureHandler failureHandler;
    @Autowired
    private Oauth2AuthenticationSuccessHandler successHandler;

    @Bean
    public EncryptPasswordEncoder passwordEncoder() {
        return new EncryptPasswordEncoder();
    }

    /**
     * 放行这部分链接
     * @param web web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/userlogin","/userlogout","/userjwt");
    }

    /**
     * 开启跨域，并放行部分链接
     *
     * @param http HttpSecurity
     * @throws Exception 抛出异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.exceptionHandling().authenticationEntryPoint(new AuthExceptionEntryPoint())
            .csrf().disable()
            .cors().and()
            .authorizeRequests()
            .antMatchers("/login", "/oauth/logout")
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

    /**
     * 配置密码加密方式
     * @param auth auth
     * @throws Exception 抛出异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 不定义没有password grant_type
     *
     * @return 返回值
     * @throws Exception 抛出异常
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
