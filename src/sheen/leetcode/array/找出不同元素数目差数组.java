package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 找出不同元素数目差数组
 * @Date 2024/1/31 00:09
 * @Created by sheen
 * @Description TODO
 */
public class 找出不同元素数目差数组 {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i = nums.length - 1; i>= 0; i--) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }

        int res[] = new int[nums.length];
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            map1.put(nums[i], map1.get(nums[i]) - 1);
            if(map1.get(nums[i]) == 0) {
                map1.remove(nums[i]);
            }
            res[i] = map2.keySet().size() - map1.keySet().size();
        }

        return res;
    }
}
