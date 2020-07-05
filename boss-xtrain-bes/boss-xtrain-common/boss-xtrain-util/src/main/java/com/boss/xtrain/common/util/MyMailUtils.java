package com.boss.xtrain.common.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MyMailUtils {
    private static final String SENDUSERNAME = "873190934@qq.com";
    private static final String SENDPASSWORD = "xmpfwjrpjlqfbbei";
    private MyMailUtils(){
    }
    public static void sendSimpleMail(String content,String to) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");//服务器需要认证
        properties.setProperty("mail.transport.protocol", "smtp");//声明发送邮件使用的端口

        Session session = Session.getInstance(properties);
        session.setDebug(true);//同意在当前线程的控制台打印与服务器对话信息

        Message message = new MimeMessage(session);//构建发送的信息
        message.setText(content);//信息内容
        message.setFrom(new InternetAddress(SENDUSERNAME));//发件人

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", 25, SENDUSERNAME, SENDPASSWORD);//连接发件人使用发件的服务器
        transport.sendMessage(message, new Address[]{new InternetAddress(to)});//接受邮件
        transport.close();
    }

}
