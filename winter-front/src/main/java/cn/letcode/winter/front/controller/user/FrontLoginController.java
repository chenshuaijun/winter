package cn.letcode.winter.front.controller.user;

import cn.letcode.bean.api.RespUserLogin;
import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.api.user.service.UserControllerInterface;
import cn.letcode.winter.front.bean.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户登录console
 *
 * @author chenshuaijun
 */
@RestController
public class FrontLoginController {
    private static Logger logger = LoggerFactory.getLogger(FrontLoginController.class);

    @Resource
    UserControllerInterface userController;

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public RespUserLogin doLogin(@RequestBody Login login) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(login.getLoginName());

        // 验证登陆密码
        userController.checkUserPassword(userInfo);

        logger.info("request login name is {}", login.getLoginName());

        RespUserLogin respUserLogin = new RespUserLogin();

        userInfo.setUserName(login.getLoginName());
        userInfo = userController.userLogin(userInfo);
        logger.debug("result:{}", userInfo.getMobile());


        respUserLogin.setMobile(new StringBuffer(userInfo.getUserName()).append(userInfo.getMobile()).toString());
        return respUserLogin;
    }
}
