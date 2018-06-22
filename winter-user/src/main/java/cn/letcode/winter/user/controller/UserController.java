package cn.letcode.winter.user.controller;

import cn.letcode.bean.module.UserInfo;
import cn.letcode.winter.api.user.service.UserControllerInterface;
import cn.letcode.winter.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户登录console
 * todo 带转移
 *
 * @author chenshuaijun
 */
@Api
@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    UserService userService;


    /**
     * 用户登录入口
     *
     * @param loginName
     * @param password
     */
    @ApiOperation(value = "用户登录", notes = "用户登录API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "用户登录名", required = true, paramType = "loginName", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户登录密码", required = true, paramType = "password", dataType = "String"),
    })

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    public void login(@RequestParam(value = "loginName") String loginName, @RequestParam(value = "password") String password) {

    }

}


