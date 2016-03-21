package com.qutopia.tutorial.javaee.springframework.data.redis;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 关于SortedSet的操作
 *
 * @author choaklin
 * @since 0.1.0
 * @see <a href="http://redisdoc.com/sorted_set/index.html">SortedSet</a>
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public final class SortedSetMocker extends RedisMocker {


    @Test
    public void isConnectSuccessful() {
        super.isConnectSuccessful();
    }


    @Test
    @Override
    public void mockAddAll() {
        log.info(">> 启动Spring... ");
        log.info(redisTemplate.getConnectionFactory().getConvertPipelineAndTxResults());
    }
}
