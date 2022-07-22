package sheen.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class 找出和为指定值的下标对 {
    public static void main(String[] args) {
        FindSumPairs s = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        s.add(3, 2);
        s.count(8);
    }
    static class FindSumPairs {
        private Map<Integer, Integer> map = new HashMap<>();
        private int[] nums1;
        private int[] nums2;
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for(int j=0;j<nums2.length;j++) {
                map.put(nums2[j], map.getOrDefault(nums2[j], 0) + 1);
            }
        }

        public void add(int index, int val) {
            map.put(nums2[index], map.get(nums2[index]) - 1);
            nums2[index] += val;
            map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            int res = 0;
            for(int i=0;i<nums1.length;i++) {
                res += map.getOrDefault(tot - nums1[i], 0);
            }
            return res;
        }
    }
}
