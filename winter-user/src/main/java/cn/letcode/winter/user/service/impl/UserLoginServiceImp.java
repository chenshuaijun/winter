package cn.letcode.winter.user.service.impl;

import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.user.bean.User;
import cn.letcode.winter.user.repository.UserRepository;
import cn.letcode.winter.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登录服务实现类
 *
 * @author chenshuaijun
 * @version 1.0
 * @since 2017年10月15日
 */
@Service("userLoginService")
public class UserLoginServiceImp implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserLoginServiceImp.class);

    @Resource
    UserRepository userRepository;


    public UserInfo userLogin() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile("18616016112");
        User user = userRepository.findUserById(9L);
        logger.info("query from member,set result is : {}", "18616016112");
        logger.info("query from member,set result is : {}",user.getName());
        userInfo.setUserName(user.getName());
        return userInfo;
    }

    @Override
    public void cleanUserSession(String sessionId) {

    }
}
