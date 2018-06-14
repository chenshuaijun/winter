package cn.letcode.winter.api.user.service;


import cn.letcode.bean.module.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "winter-service-user")
public interface UserControllerInterface {
    /**
     * 用户登陆
     * 后续优化
     * method = RequestMethod.GET
     *
     * @return produces = {"application/json;charset=UTF-8"})
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public UserInfo userLogin(UserInfo userInfo);

    /**
     * 用户登录请求入口（接口）,用户登出session处理
     *
     * @param sessionid 用户登出信息 sessionid
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/logoutClearSession", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void logoutClearSession(String sessionid);
}
