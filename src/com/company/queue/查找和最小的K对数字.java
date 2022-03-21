package com.company.queue;

import java.util.*;

/**
 * @Classname 查找和最小的K对数字
 * @Date 2022/1/14 12:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Set<Pair> set = new HashSet<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> nums1[o1.aIndex] + nums2[o1.bIndex] - nums1[o2.aIndex] - nums2[o2.bIndex]);
        List<List<Integer>> res = new ArrayList<>();
        Pair pair = new Pair(0, 0);
        queue.offer(pair);
        set.add(pair);
        while (k-- != 0 && !queue.isEmpty()) {
            pair = queue.poll();
            res.add(Arrays.asList(nums1[pair.aIndex], nums2[pair.bIndex]));
            Pair a = new Pair(pair.aIndex + 1, pair.bIndex);
            Pair b = new Pair(pair.aIndex, pair.bIndex + 1);
            if(pair.aIndex + 1 < nums1.length && !set.contains(a)) {
                queue.offer(a);
                set.add(a);
            }
            if(pair.bIndex + 1 < nums2.length && !set.contains(b)) {
                queue.offer(b);
                set.add(b);
            }
        }
        return res;
    }

    public static class Pair{
        int aIndex;
        int bIndex;

        public Pair(int aIndex, int bIndex) {
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return aIndex == pair.aIndex && bIndex == pair.bIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(aIndex, bIndex);
        }
    }
}
