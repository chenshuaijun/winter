package cn.letcode.winter.api.user.service;


import cn.letcode.bean.module.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "winter-service-user")
public interface UserLoginService {
    /**
     * 用户登陆
     * 后续优化
     * method = RequestMethod.GET
     *
     * @return
     */
    @RequestMapping(value = "/userLogin")
    public UserInfo userLogin(UserInfo userInfo);
}
