package cn.letcode.winter.webmagic.controller;

import java.io.Serializable;

/**
 * 公共返回数据
 */
public class ResponseData implements Serializable {
    private String retcode;
    private String retMessage;
    private Object result;


    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
