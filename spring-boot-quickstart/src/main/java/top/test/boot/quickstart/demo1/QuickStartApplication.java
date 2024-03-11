package top.test.boot.quickstart.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXS
 */
@SpringBootApplication
@RestController
@Slf4j
public class QuickStartApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuickStartApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功");
        log.info("测试地址 : http://localhost:{}/hello",env.getProperty("server.port"));
    }

    @GetMapping("hello")
    public String   getHello(){
        return "hello world 321";
    }
}
