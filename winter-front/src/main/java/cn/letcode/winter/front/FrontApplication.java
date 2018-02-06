package cn.letcode.winter.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableAutoConfiguration
//@ComponentScan("/cn/letcode/winter/api")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FrontApplication {
    public static void main(String[] arg) {
        SpringApplication.run(FrontApplication.class, arg);
    }
}
