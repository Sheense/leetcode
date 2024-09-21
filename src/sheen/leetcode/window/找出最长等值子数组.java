package sheen.leetcode.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 找出最长等值子数组
 * @Date 2024/5/23 00:25
 * @Created by sheen
 * @Description TODO
 */
public class 找出最长等值子数组 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        int res = 0;
        for(List<Integer> list : map.values()) {
            for(int i = 0, j = 0; i < list.size(); i++) {
                while (list.get(i) - list.get(j) + 1 - (i - j + 1) > k) {
                    j++;
                }
                res = Math.max(res, i - j + 1);

            }
        }

        return res;
    }
}
