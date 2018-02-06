package cn.letcode.winter.webmagic.controller;

import cn.letcode.winter.webmagic.bean.WxCheckSignature;
import cn.letcode.winter.webmagic.mapper.DoubleColorBallMapper;
import cn.letcode.winter.webmagic.model.DoubleColorBall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/xcx")
public class ApplicationController {
    private static Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    private static String token = "winter";


    @Resource
    DoubleColorBallMapper doubleColorBallMapper;

    /**
     * 微信小程序推送监测请求功能
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String checkSignature(@ModelAttribute WxCheckSignature wxCheckSignature) {

        logger.info("request params signature is {},timestamp is {},nonce is {}", wxCheckSignature.getSignature(), wxCheckSignature.getTimestamp(), wxCheckSignature.getNonce());
        boolean ret = checkSignature(wxCheckSignature.getSignature(), wxCheckSignature.getTimestamp(), wxCheckSignature.getNonce());
        if (ret) {
            return wxCheckSignature.getEchostr();
        }
        return "false";
    }





    /**
     * 用户登录请求入口（接口）
     *
     * @return 用户登录成功后返回的信息
     */
    @RequestMapping(method = RequestMethod.POST, value = "/queryDoubleColorBall", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseData login() {
        ResponseData responseData = new ResponseData();
        DoubleColorBall doubleColorBall = doubleColorBallMapper.selectByMaxKey();
        responseData.setRetcode("0000");
        responseData.setRetMessage("查询成功");
        responseData.setResult(doubleColorBall);
        return responseData;
    }


    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */

    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */

    private static String byteToHexStr(byte mByte) {

        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        char[] tempArr = new char[2];

        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];

        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);

        return s;

    }
}
