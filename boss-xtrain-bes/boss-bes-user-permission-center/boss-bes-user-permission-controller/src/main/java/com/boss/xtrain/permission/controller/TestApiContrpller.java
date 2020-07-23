package com.boss.xtrain.permission.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/education/bes/v1/department")
public class TestApiContrpller{

    @GetMapping("/testSentinel")
    @SentinelResource(value = "testSentinel", blockHandler = "exceptionHandler", fallback = "fallbackHandler")
    public String testSentinel(@RequestParam int i) {
        if (i == 1) {
            throw new IllegalArgumentException();
        } else {
            return "SUCCESS";
        }
    }

    /**
     * 对限流与阻塞处理
     */
    public String exceptionHandler(int i, Throwable t) {
        log.error( "service system fallback -> and request is null", t);
        return "service system fallback -> and request is null";
    }

    /**
     *
     */
    public String defaultFallback(int t) {
        log.error( "service system fallback -> and request is null");
        return "service system fallback -> and request is null";
    }
}
