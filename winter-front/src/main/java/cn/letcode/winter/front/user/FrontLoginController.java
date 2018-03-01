package cn.letcode.winter.front.user;

import cn.letcode.bean.api.RespUserLogin;
import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.api.user.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录console
 *
 * @author chenshuaijun
 */
@RestController
public class FrontLoginController {
    private static Logger logger = LoggerFactory.getLogger(FrontLoginController.class);

    @Autowired
    UserLoginService userLoginService;

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public RespUserLogin login() {
        RespUserLogin respUserLogin = new RespUserLogin();
        UserInfo userInfo = new UserInfo();
        userInfo = userLoginService.userLogin(userInfo);
        logger.debug("result:{}", userInfo.getMobile());
        respUserLogin.setMobile(userInfo.getMobile());
        return respUserLogin;
    }
}
