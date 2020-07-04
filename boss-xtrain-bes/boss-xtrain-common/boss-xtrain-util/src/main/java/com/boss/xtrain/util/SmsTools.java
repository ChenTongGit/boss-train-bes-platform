package com.boss.xtrain.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsTools {
    private SmsTools(){

    }
    //PRODUCT:云通信短信API产品,开发者无需替换
    /**
     * DOMAIN: 产品域名,开发者无需替换
     */
    private static final String PRODUCT = "Dysmsapi";

    private static final String DOMAIN = "dysmsapi.aliyuncs.com";
    // 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String ACCESSKEYID = "LTAI4G7zYShGjj8C3vcxxq6r";
    private static final String ACCESSKEYSECRET = "DcTV81NPHLGXOF78F0Nq0bSeCbBARB";
    private static final String REGIONID = "cn-hangzhou";
    private static final String TEMPLETECODE = "SMS_194900523";
    public static SendSmsResponse sendSms(String phone, String code, String templateCode) {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");




        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile(REGIONID, ACCESSKEYID, ACCESSKEYSECRET);
            DefaultProfile.addEndpoint(REGIONID, REGIONID, PRODUCT, DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号，这里都是使用传输的参数的，没有写死。
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("bosslearning");
            //需要修改为自己的签名

            //必填:短信模板-可在短信控制台中找到
            //request.setTemplateCode("SMS_152440521");//两种方法，可以直接指定模板
            request.setTemplateCode(templateCode);
            //获取调用方法，根据传的参数指定模板。二者任选其一。
            /**
            * //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            *         request.setSmsUpExtendCode("90997");
            *
            *         //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            *         request.setOutId("yourOutId");
            */
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(code);
            sendSmsResponse = acsClient.getAcsResponse(request);
        }catch (ClientException e){
            log.info(e.getMessage());
        }

        return sendSmsResponse;
    }
    public static SendSmsResponse sendSmsWithTemplateCode(String phone) {
        // 验证码（指定长度的随机数）
        String code = CodeUtils.generateVerifyCode(6);
        //短信的验证码
        String TemplateParam = "{\"code\":\""+code+"\"}";
        return sendSms(phone,TemplateParam,TEMPLETECODE);
    }
}
