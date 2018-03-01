package cn.letcode.bean.module;

/**
 * 用户信息实体对象
 *
 * @author chenshuaijun
 * @since v1.0
 */
public class UserInfo {
    /**
     * 用户ID
     */
    private String userId;
    private String mobile;
    private String userName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
