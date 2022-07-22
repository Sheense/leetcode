package sheen.leetcode.greedyAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class 目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++) {
            Map<Integer, Integer> m = new HashMap<>();
            for(int j: map.keySet()) {
                m.put(j+nums[i], m.getOrDefault(j+nums[i], 0) + map.get(j));
                m.put(j-nums[i], m.getOrDefault(j-nums[i], 0) + map.get(j));
            }
            map = m;
        }
        return map.getOrDefault(S, 0);
    }
}
