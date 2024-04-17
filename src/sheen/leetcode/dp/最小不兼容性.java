package sheen.leetcode.dp;

import java.util.*;

/**
 * @Classname 最小不兼容性
 * @Date 2023/6/28 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小不兼容性 {

    public int minimumIncompatibility(int[] nums, int k) {
        int len = 1 << nums.length;
        int MAX = Integer.MAX_VALUE;
        int[] dp = new int[len];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        Map<Integer, Integer> value = new HashMap<>();
        int group = nums.length / k;
        for(int i = 0; i < len; i++) {
            if(Integer.bitCount(i) != group) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean flag = true;
            for(int j = 0; j < nums.length; j++) {
                if(((1 << j) & i) != 0) {
                    if(set.contains(nums[j])) {
                        flag = false;
                        break;
                    }
                    set.add(nums[j]);
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                }
            }
            if(flag) {
                value.put(i, max - min);
            }
        }

        for(int i = 0; i < len; i++) {
            if(dp[i] == MAX) {
                continue;
            }
            int sub = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((1 << j) & i) == 0) {
                    sub |= (1 << j);
                }
            }
            if(Integer.bitCount(sub) < group) {
                continue;
            }
            //next为sub的子集
            int next = sub;
            while (next > 0) {
                if(value.containsKey(next)) {
                    dp[i | next] = Math.min(dp[i | next], dp[i] + value.get(next));
                }
                next = (next - 1) & sub;
            }
        }
        return dp[len - 1] == Integer.MAX_VALUE ? -1 : dp[len - 1];
    }
}
