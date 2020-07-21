package com.boss.xtrain.authentication.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class CookieUtils {
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie -> cookie != null && Objects.equals(cookie.getName(), name))
                .findFirst();
            return result.orElse(null);
        } else {
            return null;
        }
    }

    public static String getHeader(HttpServletRequest request, String name){
        return request.getHeader(name);
    }

    public static String getBody(HttpServletRequest request) throws IOException {
        byte[] bytes = {};
        IOUtils.readFully(request.getInputStream(), bytes);
        String body = Arrays.toString(bytes);
        String name = request.getParameter("name");
        if(StringUtils.isNotBlank(body)){
            log.info("body: " + body);
            log.info("name: " + name);
        }
        return body;
    }

}
