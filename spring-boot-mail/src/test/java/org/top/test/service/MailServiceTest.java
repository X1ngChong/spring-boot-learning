package org.top.test.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;

    /**
     * 发送简单文本
     */
    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("1780473845@qq.com","测试文本","这是测试普通文件邮件");
    }

    /**
     *html类型邮件测试
     */

    @Test
    void sendHtmlMail() throws MessagingException {
        String content = """
                <body>
                <h2>这是测试html的邮件</h2>
                <img src="https://tse2-mm.cn.bing.net/th/id/OIP-C.PIzcb3tDQ2BKlDwcOPlT8QAAAA?w=184&h=246&c=7&r=0&o=5&pid=1.7"/>
                </body>
                """;
        mailService.sendHtmlMail("1780473845@qq.com","测试文本",content);
    }

    @Test
    void sendAttachMail() throws MessagingException {
        String filePath ="C:\\Users\\JXS\\Pictures\\123.jpg";
        mailService.sendAttachmentsMail("1780473845@qq.com","测试文本","这是带附件的邮件",filePath);
    }
}