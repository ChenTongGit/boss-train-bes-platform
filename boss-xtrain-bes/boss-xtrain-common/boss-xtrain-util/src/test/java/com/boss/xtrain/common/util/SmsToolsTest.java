package com.boss.xtrain.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmsToolsTest {

    @Test
    public void sendSmsWithTemplateCode() {
        SmsTools.sendSmsWithTemplateCode("13080702769");
    }
}