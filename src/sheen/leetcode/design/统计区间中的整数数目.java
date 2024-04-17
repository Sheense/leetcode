package sheen.leetcode.design;

import java.util.TreeMap;

/**
 * @Classname 统计区间中的整数数目
 * @Date 2023/12/16 10:23
 * @Created by sheen
 * @Description TODO
 */
public class 统计区间中的整数数目 {
    static class CountIntervals {
        private TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        public CountIntervals() {

        }

        public void add(int left, int right) {
            Integer next = map.floorKey(right);
            while (next != null && map.get(next) >= left) {
                int r = map.get(next);
                int l = next;
                left = Math.min(l, left);
                right = Math.max(r, right);
                count -= r - l + 1;
                map.remove(next);
                next = map.floorKey(right);
            }
            count += right - left + 1;
            map.put(left, right);
        }

        public int count() {
            return count;
        }
    }
}
