package com.boss.xtrain.controller;

import com.boss.xtrain.util.CodeUtils;
import com.boss.xtrain.util.SmsTools;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sms")
public class SmsCtrl {

    /**
     * 发送短信
     * @param phone
     * @param request
     * @return
     * @throws ClientException
     */
    @RequestMapping(value = "/smsXxs")
    @ResponseBody
    public Map<String,Object> smsXxs(@RequestParam(value = "phone")String phone, HttpServletRequest request) throws ClientException, ClientException {
        Map<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtils.generateVerifyCode(6);
        //短信的验证码
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_194900523";
        SendSmsResponse response = SmsTools.sendSms(phone,TemplateParam,TemplateCode);
        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }
        return map;
    }
}
