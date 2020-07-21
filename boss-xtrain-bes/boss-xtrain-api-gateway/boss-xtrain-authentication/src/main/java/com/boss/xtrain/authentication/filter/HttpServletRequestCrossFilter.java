package com.boss.xtrain.authentication.filter;

import com.boss.xtrain.authentication.utils.CookieUtils;
import com.boss.xtrain.common.core.http.CommonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class HttpServletRequestCrossFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        log.info("进入 HttpServletRequestCrossFilter");
        ParameterRequestWrapper parameterRequestWrapper = new ParameterRequestWrapper(request);

        log.info("body:{}", CookieUtils.getBody(request));
        CookieUtils.getHeader(request, "");
        //把自定义的request传入过滤器链，进入下一个过滤器
        filterChain.doFilter(parameterRequestWrapper, response);
    }
}
