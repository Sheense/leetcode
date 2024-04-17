package sheen.leetcode.sort;

import java.util.Arrays;

/**
 * @Classname 统计将重叠区间合并成组的方案数
 * @Date 2024/3/27 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 统计将重叠区间合并成组的方案数 {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (x, y) -> x[0] - y[0]);

        int pre = -1;
        int count = 0;
        for(int i = 0; i < ranges.length; i++) {
            if(pre == -1 || pre < ranges[i][0]) {
                pre = ranges[i][1];
                count++;
            }{
                pre = Math.max(pre, ranges[i][1]);
            }
        }

        int res = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        for(int i = 0; i < count; i++) {
            res *= 2;
            res %= mod;
        }

        return res;
    }
}
