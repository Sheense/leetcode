package sheen.leetcode.binarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 找出唯一性数组的中位数
 * @Date 2024/8/27 01:02
 * @Created by sheen
 * @Description TODO
 */
public class 找出唯一性数组的中位数 {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long) n * (n + 1) / 2 + 1) / 2;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(check(nums, mid, k)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int upper, long k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        long cnt = 0;
        for(int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > upper) {
                int v = nums[l++];
                map.put(v, map.getOrDefault(v, 0) - 1);
                if(map.get(v) == 0) {
                    map.remove(v);
                }
            }
            cnt += r - l + 1;
            if(cnt >= k) return true;
        }

        return false;
    }
}
