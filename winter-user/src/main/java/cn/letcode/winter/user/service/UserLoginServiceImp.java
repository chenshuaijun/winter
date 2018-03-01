package cn.letcode.winter.user.service;

import cn.letcode.bean.module.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 用户登录服务实现类
 *
 * @author chenshuaijun
 * @version 1.0
 * @since 2017年10月15日
 */
@Service("userLoginService")
public class UserLoginServiceImp {
    private static Logger logger = LoggerFactory.getLogger(UserLoginServiceImp.class);

    public UserInfo userLogin() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile("18616016112");
        logger.info("query from member,set result is : {}", "18616016112");
        return userInfo;
    }
}
