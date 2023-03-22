package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 统计中位数为K的子数组
 * @Date 2023/3/16 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计中位数为K的子数组 {
    public static void main(String[] args) {
        统计中位数为K的子数组 s = new 统计中位数为K的子数组();
        System.out.println(s.countSubarrays(new int[]{3,2,1,4,5}, 4));
    }
    public int countSubarrays(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int index = -1;
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                pre[i] = Integer.compare(nums[i], k);
            }else {
                pre[i] = pre[i - 1] + Integer.compare(nums[i], k);
            }

            if(nums[i] == k) {
                index = i;
            }
            if(index != - 1) {
                int key = index == 0 ? pre[i] : (pre[i] - pre[index - 1]);
                count.put(key, count.getOrDefault(key, 0) + 1);
            }
        }

        if(index == 0) {
            ans += count.getOrDefault(0, 0);
            ans += count.getOrDefault(1, 0);
        }else {
            for(int i = -1; i < index; i++) {
                int v = i == -1 ? pre[index - 1] : pre[index - 1] - pre[i];
                ans += count.getOrDefault(-v, 0);
                ans += count.getOrDefault(1 - v, 0);
            }
        }

        return ans;
    }
}
