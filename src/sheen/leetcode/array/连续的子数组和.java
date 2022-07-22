package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class 连续的子数组和 {
    public static void main(String[] args) {
        连续的子数组和 s = new 连续的子数组和();
        System.out.println(s.checkSubarraySum(new int[]{1,3,6,0,9,6,9}, 7));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        nums[0]%=k;
        map.put(nums[0], 0);
        for(int i = 1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            nums[i] %= k;
            if(nums[i] == 0) return true;
            if(map.containsKey(nums[i])) {
                int len = i - map.get(nums[i]);
                if(len >= 2) return true;
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
