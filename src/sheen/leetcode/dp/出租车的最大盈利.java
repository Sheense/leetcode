package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 出租车的最大盈利
 * @Date 2023/12/8 00:25
 * @Created by sheen
 * @Description TODO
 */
public class 出租车的最大盈利 {

    public static void main(String[] args) {
        出租车的最大盈利 s = new 出租车的最大盈利();
        System.out.println(s.maxTaxiEarnings(5, new int[][]{{2,5,4},{1,5,1}}));
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (x, y) -> x[1] - y[1]);
        long[] dp = new long[rides.length];
        long res = 0;
        for(int i = 0; i < dp.length; i++) {
            int index = search(rides, rides[i][0], i - 1);
            if (i == 0) {
                dp[i] = rides[i][1] - rides[i][0] + rides[i][2];
            }else if(index == -1) {
                dp[i] = Math.max(rides[i][1] - rides[i][0] + rides[i][2], dp[i - 1]);
            }else {
                dp[i] = Math.max(dp[i - 1], (long)rides[i][1] - rides[i][0] + rides[i][2] + dp[index]);
            }
            res = Math.max(res, dp[i]);

        }
        return res;

    }

    public int search(int[][] ride, int start, int end) {
        if (end == -1) {
            return -1;
        }
        int left = 0;
        int right = end;
        while (left <= right) {
            int mid = (right + left) / 2;
            if(ride[mid][1] > start) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
