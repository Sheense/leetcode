package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 必须拿起的最小连续卡牌数
 * @Date 2022/5/1 10:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 必须拿起的最小连续卡牌数 {
    public int minimumCardPickup(int[] cards) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i])) {
                int v = i - map.get(cards[i]) + 1;
                res = Math.min(res, v);
            }
            map.put(cards[i], i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
