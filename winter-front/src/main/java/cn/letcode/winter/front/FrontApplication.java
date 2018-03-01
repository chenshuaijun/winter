package cn.letcode.winter.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages={"cn.letcode"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.letcode"})
@RestController
public class FrontApplication {
    public static void main(String[] arg) {
        SpringApplication.run(FrontApplication.class, arg);
    }
}
