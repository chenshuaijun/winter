package cn.letcode.winter.user.controller;

import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.api.user.service.UserControllerInterface;
import cn.letcode.winter.user.service.UserService;
import cn.letcode.winter.user.service.impl.UserLoginServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户登录console
 * todo 带转移
 *
 * @author chenshuaijun
 */

@RestController
public class UserController implements UserControllerInterface {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @Override
    public UserInfo userLogin(UserInfo userInfo) {
        userInfo = userService.userLogin();
        userInfo.setUserId("1234");
        return userInfo;
    }

    @Override
    public void logoutClearSession(String sessionId) {
        userService.cleanUserSession(sessionId);
    }
}


