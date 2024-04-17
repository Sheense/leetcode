package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 数组中不等三元组的数目
 * @Date 2023/6/13 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组中不等三元组的数目 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        List<Integer> key = new ArrayList<>(map.keySet());
        for(int i = 0; i < key.size() - 2; i++) {
            for(int j = i + 1; j < key.size() - 1; j++) {
                for(int z = j + 1; z < key.size(); z++) {
                    res += map.get(key.get(i)) * map.get(key.get(j)) * map.get(key.get(z));
                }
            }
        }
        return res;
    }
}
