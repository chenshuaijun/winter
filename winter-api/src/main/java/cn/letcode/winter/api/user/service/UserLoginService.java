package cn.letcode.winter.api.user.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("winter-service-user")
public interface UserLoginService {
    @RequestMapping(method = RequestMethod.GET,value = "/userLogin")
    public Map userLogin();
}
