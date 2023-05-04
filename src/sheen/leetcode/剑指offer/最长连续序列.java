package sheen.leetcode.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 最长连续序列
 * @Date 2023/3/23 3:43 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        UnionSet unionSet = new UnionSet();
        for(int i = 0; i < nums.length; i++) {
            unionSet.union(nums[i]);
        }

        return unionSet.getRes();
    }

    public static class UnionSet{
        private Map<Integer, Integer> map = new HashMap<>();
        private Map<Integer, Integer> count = new HashMap<>();

        public void union(int v) {
            if(map.containsKey(v)) {
                return;
            }else {
                map.put(v, v);
                count.put(v, 1);
            }
            int r2 = findRoot(v);
            if(map.containsKey(v - 1)) {
                int r1 = findRoot(v - 1);
                unionRoot(r1, r2);
                r2 = r1;
            }

            if(map.containsKey(v + 1)) {
                int r1 = findRoot(v + 1);
                unionRoot(r1, r2);
            }
        }

        private void unionRoot(int r1, int r2) {
            map.put(r2, r1);
            count.put(r1, count.get(r1) + count.get(r2));
        }

        private int findRoot(int v) {
            while (map.get(v) != v) {
                v = map.get(v);
            }
            return v;
        }

        public int getRes() {
            int max = 0;
            for(int item : count.values()) {
                max = Math.max(item, max);
            }
            return max;
        }
    }
}
