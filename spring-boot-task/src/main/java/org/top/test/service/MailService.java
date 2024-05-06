package org.top.test.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author JXS
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromValue;

    /**
     * 发送html文本
     */

    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(mail,true);
        mailMessage.setFrom(fromValue);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        //第二个参数为true才能接受HTML文本
        mailMessage.setText(content,true);

        javaMailSender.send(mail);

    }


}
