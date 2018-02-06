package cn.letcode.winter.front.user.service;


import cn.letcode.winter.front.user.bean.UserLogin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient("winter-service-user")
public interface UserLoginConsumer {
    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public Map logout1() ;
}
