package sheen.leetcode.design;

import java.util.*;

/**
 * @Classname 将数据流变为多个不相交区间
 * @Date 2021/10/9 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 将数据流变为多个不相交区间 {
    class SummaryRanges {

        private TreeMap<Integer, int[]> min;
        private Set<Integer> set = new HashSet<>();
        public SummaryRanges() {
            min = new TreeMap<>();
        }

        public void addNum(int val) {
            if(set.contains(val)) {
                return;
            }
            set.add(val);
            Integer up = min.ceilingKey(val);
            Integer down = min.floorKey(val);
            boolean flag = false;
            if(up == null && down != null) {
                int[] item = min.get(down);
                if(val >= item[0] && val <= item[1]) {
                    return;
                }
                if(item[1] + 1 == val) {
                    item[1] ++;
                }else {
                    defaultAdd(val);
                }
            }else if(up != null && down == null) {
                int[] item = min.get(up);
                if(up - 1 == val) {
                    item[0] = val;
                    min.remove(up);
                    min.put(val, item);
                } else {
                    defaultAdd(val);
                }
            }else if(up != null && down != null) {
                int[] item1 = min.get(down);
                int[] item2 = min.get(up);
                if(item1[0] <= val && item1[1] >= val) {
                    return;
                }

                if(item1[1] + 1 == val && val + 1 == up) {
                    int[] item = {item1[0], item2[1]};
                    min.remove(up);
                    min.put(down, item);
                }else if(item1[1] + 1 == val) {
                    item1[1] ++;
                }else if(val + 1 == up) {
                    item2[0] = val;
                    min.remove(up);
                    min.put(val, item2);
                }else {
                    defaultAdd(val);
                }
            }else {
                defaultAdd(val);
            }
        }

        private void defaultAdd(int  val) {
            int[] item = {val, val};
            min.put(val, item);
        }

        public int[][] getIntervals() {
            int[][] res = new int[min.size()][2];
            int index = 0;
            for(int[] entry : min.values()) {
                res[index ++] = entry;
            }
            return res;
        }
    }


}
