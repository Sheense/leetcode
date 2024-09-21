package sheen.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 拾起K个1需要的最少行动次数
 * @Date 2024/7/4 01:26
 * @Created by sheen
 * @Description TODO
 */
public class 拾起K个1需要的最少行动次数 {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        List<Integer> pos = new ArrayList<>();
        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]== 0) continue;
            pos.add(i);
            c = Math.max(c, 1);
            if(i > 0 && nums[i - 1] == 1) {
                if(i > 1 && nums[i - 2] == 1) {
                    c = Math.max(c, 3);
                }else {
                    c = Math.max(c, 2);
                }
            }
        }

        c = Math.min(c, k);
        if(maxChanges >= k - c) {
            return Math.max(0, c - 1) + 2 * (k - c);
        }

        int n = pos.size();
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + pos.get(i);
        }

        long ans = Long.MAX_VALUE;
        int size = k - maxChanges;
        for(int right = size; right <= n; right++) {
            int left = right - size;
            int mid = left + size / 2;
            long index = pos.get(mid);
            long s1 = index * (mid - left) - (sum[mid] - sum[left]);
            long s2 = sum[right] - sum[mid] - index * (right - mid);
            ans = Math.min(ans, s1 + s2);
        }

        return 2 * maxChanges + ans;
    }
}
