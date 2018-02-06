package cn.letcode.winter.front.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@EnableDiscoveryClient
@RestController
public class HelloClientApplication {
    @Autowired
	HelloClient client;

	@RequestMapping("/")
	public String hello() {
		return client.hello();
	}


	@FeignClient("winter-service-user")
	interface HelloClient {
		@RequestMapping(value = "/", method = GET)
		String hello();
	}
}
