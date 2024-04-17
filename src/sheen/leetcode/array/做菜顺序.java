package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 做菜顺序
 * @Date 2023/10/22 01:27
 * @Created by sheen
 * @Description TODO
 */
public class 做菜顺序 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[] pre = new int[satisfaction.length];
        for(int i = 0; i < pre.length; i++) {
            if(i == 0) {
                pre[i] = satisfaction[satisfaction.length - 1];
            }else {
                pre[i] = pre[i -1 ] + satisfaction[satisfaction.length - 1 - i];
            }
        }
        int res = 0;
        int now = 0;
        for(int i = 0; i < pre.length; i++) {
            now += pre[i];
            res = Math.max(res, now);
        }
        return res;
    }
}
