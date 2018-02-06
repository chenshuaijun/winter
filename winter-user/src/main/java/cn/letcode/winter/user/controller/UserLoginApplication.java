package cn.letcode.winter.user.controller;

import cn.letcode.winter.user.service.UserLoginServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户登录console
 * todo 带转移
 *
 * @author chenshuaijun
 */
@RestController
public class UserLoginApplication {
    private static Logger logger = LoggerFactory.getLogger(UserLoginApplication.class);

    @Resource
    UserLoginServiceImp userLoginService;

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map login() {
        return userLoginService.userLogin();
    }

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map logout() {
        Map result = userLoginService.userLogin();
        result.put("name", "ffffff");
        result.put("userinfo",(String) result.get("name"));
        return result;
    }
}
