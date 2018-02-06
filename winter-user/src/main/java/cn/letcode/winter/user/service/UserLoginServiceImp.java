package cn.letcode.winter.user.service;

import cn.letcode.util.redis.RedisServiceImp;
//import cn.letcode.winter.user.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @Resource
//    private UserMapper userMapper;

    @Resource
    private RedisServiceImp redisServiceImp;

    public Map userLogin() {
        return queryUserInfoByName("");
    }

    public Map queryUserInfoByName(String userName) {
//        Map result = userMapper.selectByPrimaryKey(1);
        Map result = new HashMap();
        List<Object> list = new ArrayList<Object>();
        list.add("name");
        Map map = new HashMap();
        map.put("name", "chensj");
        list.add(map);
        result.put("list", list);


        result.put("userid", redisServiceImp.getRedisSquence("userid"));

        logger.info("result : " + result.values());
        return result;
    }
}
