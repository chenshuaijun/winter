package cn.letcode.winter.front.user;

import cn.letcode.winter.front.user.service.UserLoginConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户登录console
 * todo 带转移
 *
 * @author chenshuaijun
 */
@RestController
public class FrontLoginController {
    private static Logger logger = LoggerFactory.getLogger(FrontLoginController.class);

    @Autowired
    UserLoginConsumer userLogin;

    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map login() {
        Map result = userLogin.logout1();
        result.put("is_front",true);
        logger.info(result.toString());
        logger.debug(result.toString());
        logger.debug("result:{}",result.toString());
        return result;
    }


}
