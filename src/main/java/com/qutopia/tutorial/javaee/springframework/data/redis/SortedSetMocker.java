package com.qutopia.tutorial.javaee.springframework.data.redis;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    static final String LOCAL_SORTED_SET_KEY = "choaklin_redis_experiment_sortedset_key";
    @Resource(name = "redisTemplate")
    ZSetOperations<String, SortedBean> zSetOperations;

    @Test
    public void isConnectSuccessful() {
        super.isConnectSuccessful();
    }



    @Test
    @Override
    public void mockAddAll() {

        int dataSize = 100000;
        BoundZSetOperations zSetOperations = redisTemplate.boundZSetOps(LOCAL_SORTED_SET_KEY);

        Set<SortedBean> onePersistData = this.buildPersistSortedSetData(dataSize);
        long onePersistStartMills = System.currentTimeMillis();
        for (SortedBean sortedBean : onePersistData) {
            zSetOperations.add(sortedBean.getValue(), sortedBean.getScore());
        }
        log.info(">> 遍历存储[" + dataSize + "]条数据共花费[" + (System.currentTimeMillis() - onePersistStartMills) + "]毫秒");

        log.info(">>>>>>>>>>>>>>> ↑遍历存储↑ ---- ↓批量存储↓ >>>>>>>>>>>>>>>>>>>");

        Set<SortedBean> batchPersistData = this.buildPersistSortedSetData(dataSize);
        long batchPersistStartMills = System.currentTimeMillis();
        zSetOperations.add(batchPersistData);
        log.info(">> 批处理存储[" + dataSize + "]条数据共花费[" + (System.currentTimeMillis() - batchPersistStartMills) + "]毫秒");
    }


    private Set<SortedBean> buildPersistSortedSetData(int size) {
        Set<SortedBean> sortedBeanSet = new HashSet<SortedBean>(size);
        SortedBean sortedBean;
        for (double i = 0; i++ < size;) {
            sortedBean = new SortedBean();
            sortedBean.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
            sortedBean.setScore(i);
            sortedBeanSet.add(sortedBean);
        }
        return sortedBeanSet;
    }
}
