package cn.letcode.winter.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

// 添加管理jar包中的注解，指定路径的管理
@ComponentScan("/cn/letcode/")
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] arg) {
        SpringApplication.run(UserApplication.class, arg);
    }
}
