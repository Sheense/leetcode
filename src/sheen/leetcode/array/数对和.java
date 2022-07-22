package sheen.leetcode.array;

import java.util.*;

public class 数对和 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int key:map.keySet()) {
            int other = target - key;
            if(map.containsKey(other)) {
                int count;
                if(other == key) {
                    count = map.get(key) / 2;
                } else {
                    count = Math.min(map.get(other), map.get(key));
                }
                map.put(other, map.get(other) - count);
                map.put(key, map.get(key) - count);
                while (count!=0) {
                    res.add(Arrays.asList(other, key));
                    count--;
                }
            }
        }
        return res;
    }
}
