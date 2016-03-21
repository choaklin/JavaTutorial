package com.qutopia.tutorial.javaee.springframework.data.redis;

import lombok.Data;
import org.springframework.data.redis.core.ZSetOperations;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
@Data
public class SortedBean implements ZSetOperations.TypedTuple<String> {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 分值
     */
    private Double score;


    public String getValue() {
        return userId;
    }

    public int compareTo(ZSetOperations.TypedTuple<String> o) {
        return 0;
    }
}
