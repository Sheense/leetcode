package sheen.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 使数组和小于等于x的最少时间
 * @Date 2024/1/19 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 使数组和小于等于x的最少时间 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int [][] dp = new int[n+1][n+1];
        int s1 = 0;
        int s2 = 0;
        List<List<Integer>> nums = new ArrayList<>();
        for(int i = 0; i < nums1.size(); i++) {
            nums.add(Arrays.asList(nums2.get(i), nums1.get(i)));
            s1 += nums1.get(i);
            s2 += nums2.get(i);
        }

        Collections.sort(nums, (z, y) -> z.get(0) - y.get(0));
        for(int j = 1; j <= n; j++) {
            int b = nums.get(j - 1).get(0);
            int a = nums.get(j - 1).get(1);
            for(int i = j; i > 0; i--) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - 1] + i * b + a);
            }
        }

        for(int i = 0; i <= n; i++) {
            if(s2 *i + s1 - dp[n][i] <= x) {
                return i;
            }
        }
        return -1;
    }
}
