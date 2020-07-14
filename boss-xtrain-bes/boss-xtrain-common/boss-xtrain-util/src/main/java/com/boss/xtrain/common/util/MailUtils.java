package com.boss.xtrain.common.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
//@Component
public class MailUtils {
//    @Value("873190934@qq.com")
    //@Value("${spring.mail.username}")
    private String mailSender;
//    @Autowired
    private JavaMailSender javaMailSender;
    /**
     * 发送文本邮件
     *
     * @param mailBean
     */
    public  void sendSimpleMail(MailBean mailBean) {
        try {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setFrom(mailSender);
            mailMessage.setTo(mailBean.getRecipient());
            mailMessage.setSubject(mailBean.getSubject());
            mailMessage.setText(mailBean.getContent());
            mailMessage.setCc(mailSender);
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    /**
     * HTML格式邮件发送
     * @param mailBean
     */
    public void sendHTMLMail(MailBean mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            //true 表示需要创建一个multipart message
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage, true);
            messageHelper.setFrom(mailSender);
            messageHelper.setTo(mailBean.getRecipient());
            messageHelper.setSubject(mailBean.getSubject());
            //抄送
            messageHelper.addCc(mailSender);
            messageHelper.setText(mailBean.getContent(), true);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


    public void sendAttachmentMail(MailBean mailBean,String path) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            //true 表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mailBean.getRecipient());
            mimeMessageHelper.setSubject(mailBean.getSubject());
            mimeMessageHelper.setText(mailBean.getContent());
            mimeMessageHelper.addCc(mailSender);
            //文件路径 目前写死在代码中，之后可以当参数传过来，或者在MailBean中添加属性absolutePath
            String absolutePath = path;
            FileSystemResource file = new FileSystemResource(new File(absolutePath));
            String fileName = absolutePath.substring(absolutePath.lastIndexOf(File.separator));
            //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
            mimeMessageHelper.addAttachment(fileName, file);
            //多个附件
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


}
