package cn.letcode.winter.user.controller;

import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.user.service.UserLoginServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户登录console
 * todo 带转移
 *
 * @author chenshuaijun
 */
@RestController
public class UserLoginApplication {
    private static Logger logger = LoggerFactory.getLogger(UserLoginApplication.class);
    // 配置文件中的msg
    @Value("${msg:unknown}")
    private String msg;


    @Resource
    UserLoginServiceImp userLoginService;

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public UserInfo userLogin() {
        UserInfo userInfo = userLoginService.userLogin();
        userInfo.setUserName(this.msg);
        userInfo.setUserId("1234");
        return userInfo;
    }

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public UserInfo logout() {
        UserInfo userInfo = userLoginService.userLogin();
        userInfo.setUserId("2324213");
        userInfo.setUserName(this.msg);
        return userInfo;
    }
}
