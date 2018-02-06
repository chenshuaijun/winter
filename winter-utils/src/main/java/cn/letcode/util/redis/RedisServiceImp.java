package cn.letcode.util.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Created by chenshuaijun on 2017/4/22. <br>
 * redis集群配置
 * Repository 持久层组件，用于标注数据访问组件
 *
 * @author chenshuaijun
 */
@Component
public class RedisServiceImp {
    private static Logger logger = LoggerFactory.getLogger(RedisServiceImp.class);
    protected int defaultLength = 6;
    protected Long defaultIncreaseNo = 1L;
    /**
     * Redis 链接对象
     */
    @Autowired
    protected RedisTemplate<?, ?> redisTemplate;


    /**
     * 根据定义的序列的名字 获取序列号，定一个序列长度，返回一个固定的长度值 <br>
     * 传入值为：getRedisSquence("seq",6);获取到的值是 3 --> 000006
     *
     * @param squName 自定义序列名称
     * @param length  序列自动补充长度
     * @return 拼接处理后的值
     */
    public String getRedisSquence(String squName, int length) {
        ValueOperations<String, Long> vo = (ValueOperations<String, Long>) redisTemplate.opsForValue();
        Long val = vo.increment(squName, defaultIncreaseNo);
        return lpadSquenceValue(String.valueOf(val), defaultLength);
    }

    /**
     * 根据定义的序列的名字 获取序列号，定一个序列长度，返回一个固定的长度值 <br>
     * 默认序列长度为 6 <br>
     * 传入值为：getRedisSquence("seq",6);获取到的值是 3 --> 000006
     *
     * @param squName 自定义序列名称
     * @return 拼接处理后的值
     */
    public String getRedisSquence(String squName) {
        return getRedisSquence(squName, defaultLength);
    }

    /**
     * 保存字符串类型的数据到redis
     *
     * @param key    关键字key
     * @param value  存入值
     * @param offset 设置到期时间
     */
    public void saveStrValue(String key, String value, long offset) {
        @SuppressWarnings("unchecked")
        ValueOperations<String, String> vo = (ValueOperations<String, String>) redisTemplate.opsForValue();
        vo.set(key, value, offset);
    }

    public static String defaultPadStr = "0";

    /**
     * 得到序列左边补0，执行补充的长度
     *
     * @param seq    序列值
     * @param length 序列长度
     * @return 补充后的字符串
     * @author chenshuaijun
     */
    public static String lpadSquenceValue(String seq, int length) {
        if (StringUtils.isBlank(seq)) {
            logger.warn("recv from redis's seq is blank :[{}],and return default '0' ", seq);
            seq = "0";
        }
        return StringUtils.leftPad(seq, length, defaultPadStr);
    }


    /**
     * redis连接池设置数据字段系列化，保证key和内容不会出现前缀乱码
     *
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<?, ?> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}