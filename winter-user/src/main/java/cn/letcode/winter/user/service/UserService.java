package cn.letcode.winter.user.service;

import cn.letcode.bean.module.UserInfo;

/**
 * 用户服务信息累
 *
 * @author chenshuaijun
 * @since v1.0.0
 */
public interface UserService {
    /**
     * 清理用户登录session信息，
     *
     * @param sessionId 用户sessionID
     */
    public void cleanUserSession(String sessionId);


    /**
     * TODO 待处理
     * @return
     */
    public UserInfo userLogin();
}
