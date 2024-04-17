package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 拿出最少数目的魔法豆
 * @Date 2024/1/18 00:18
 * @Created by sheen
 * @Description TODO
 */
public class 拿出最少数目的魔法豆 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long total = 0;
        for(int bean : beans) {
            total += bean;
        }


        long res = total;
        for(int i = 0; i < beans.length; i++) {
            res = Math.min(res, total - (beans.length - i) * (long)beans[i]);
        }
        return res;
    }
}
