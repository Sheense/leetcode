package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 全部开花的最早一天
 * @Date 2023/9/30 10:47
 * @Created by sheen
 * @Description TODO
 */
public class 全部开花的最早一天 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] items = new int[plantTime.length][2];
        for(int i = 0; i < plantTime.length; i++) {
            items[i][0] = plantTime[i];
            items[i][1] = growTime[i];
        }

        Arrays.sort(items, (x, y) -> y[1] - x[1]);
        int res = 0;
        int now = 0;

        for(int item[] : items) {
            int v = item[0] + item[1];
            int expect = v + now;
            now += item[0];
            res = Math.max(res, expect);
        }
        return res;
    }
}
