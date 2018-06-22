package cn.letcode.winter.front.bean;

/**
 * @author chensj
 * @since v1.0.1
 */
public class Result {
    /**
     * 每次产生一个新的token 这样可以延长使用期限
     */
    protected String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
