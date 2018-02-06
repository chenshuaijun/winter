package cn.letcode.winter.webmagic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.FileNotFoundException;

// 添加管理jar包中的注解，指定路径的管理
@SpringBootApplication
@MapperScan(basePackages = "cn.letcode.winter.webmagic.mapper")
@EnableScheduling
public class WebmagicApplication {

    public static void main(String[] arg) {
        SpringApplication.run(WebmagicApplication.class, arg);
    }
}
