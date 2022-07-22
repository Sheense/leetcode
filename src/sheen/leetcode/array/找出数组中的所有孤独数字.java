package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 找出数组中的所有孤独数字
 * @Date 2022/1/23 11:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组中的所有孤独数字 {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 1 && !map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
