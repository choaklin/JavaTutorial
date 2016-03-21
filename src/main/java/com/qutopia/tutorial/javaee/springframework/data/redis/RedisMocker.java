package com.qutopia.tutorial.javaee.springframework.data.redis;

import lombok.extern.log4j.Log4j;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
@Log4j
public abstract class RedisMocker {

    @Resource(name = "redisTemplate")
    protected RedisTemplate redisTemplate;

    protected void isConnectSuccessful() {
        log.info(">> connect redis: " + (!redisTemplate.isExposeConnection()));
    }

    /**
     * 批量添加元素
     */
    abstract void mockAddAll();
}
